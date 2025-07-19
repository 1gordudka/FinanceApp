package com.features.income.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.features.income.data.remote.mappers.calculateAllIncome
import com.features.income.data.remote.repository.RemoteIncomeFeatureRepository
import com.features.income.data.remote.results.RemoteObtainCreateIncomeResult
import com.features.income.data.remote.results.RemoteObtainIncomeResult
import com.features.income.data.remote.results.RemoteObtainTransactionResult
import com.finance.common.database.repository.OfflineTransactionRepository
import com.finance.common.network.repository.AccountRepository
import com.finance.common.network.results.ObtainAccountId
import com.finance.domain.transaction.Account
import com.finance.domain.transaction.Category
import com.finance.domain.transaction.Transaction
import com.finance.income.domain.models.CreateIncomeRequest
import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.results.ObtainCreateIncomeResult
import com.finance.income.domain.results.ObtainIncomeData
import com.finance.income.domain.results.ObtainTransactionResult
import com.finance.income.domain.results.ObtainUpdateIncomeResult
import kotlinx.coroutines.flow.first
import java.text.SimpleDateFormat
import java.util.*

class IncomeFeatureRepositoryImpl(
    private val accountRepository: AccountRepository,
    private val remoteIncomeFeatureRepository: RemoteIncomeFeatureRepository,
    private val offlineTransactionRepository: OfflineTransactionRepository,
    private val context: Context
) : IncomeFeatureRepository {
    override suspend fun getIncomeData(startDate: String, endDate: String): ObtainIncomeData {
        return try {
            // Всегда сначала пробуем загрузить из локальной БД
            val localTransactions = offlineTransactionRepository.getIncomeTransactions().first()
            
            if (localTransactions.isNotEmpty()) {
                // Если есть локальные данные - возвращаем их (с фильтрацией или без)
                val filteredTransactions = filterTransactionsByDate(localTransactions, startDate, endDate)
                
                ObtainIncomeData.Success(
                    startDate = startDate,
                    endDate = endDate,
                    allIncome = calculateAllIncome(filteredTransactions),
                    transactions = filteredTransactions
                )
            } else {
                // Локальных данных нет - пробуем загрузить с сети (только если есть интернет)
                if (isNetworkAvailable()) {
                    loadFromNetworkAndSave(startDate, endDate)
                } else {
                    // Нет интернета и нет локальных данных - возвращаем пустой результат
                    ObtainIncomeData.Success(
                        startDate = startDate,
                        endDate = endDate,
                        allIncome = calculateAllIncome(emptyList()),
                        transactions = emptyList()
                    )
                }
            }
        } catch (e: Exception) {
            // В случае ошибки с БД - пробуем сеть или возвращаем пустой результат
            if (isNetworkAvailable()) {
                try {
                    loadFromNetworkAndSave(startDate, endDate)
                } catch (networkException: Exception) {
                    ObtainIncomeData.Success(
                        startDate = startDate,
                        endDate = endDate,
                        allIncome = calculateAllIncome(emptyList()),
                        transactions = emptyList()
                    )
                }
            } else {
                ObtainIncomeData.Success(
                    startDate = startDate,
                    endDate = endDate,
                    allIncome = calculateAllIncome(emptyList()),
                    transactions = emptyList()
                )
            }
        }
    }
    
    private suspend fun loadFromNetworkAndSave(startDate: String, endDate: String): ObtainIncomeData {
        return try {
            val resultId = accountRepository.getAccountId()
            when (resultId) {
                ObtainAccountId.Error -> ObtainIncomeData.Success(
                    startDate = startDate,
                    endDate = endDate,
                    allIncome = calculateAllIncome(emptyList()),
                    transactions = emptyList()
                )
                is ObtainAccountId.Success -> {
                    val remoteResult = remoteIncomeFeatureRepository.getIncomeData(resultId.id, startDate, endDate)
                    when (remoteResult) {
                        RemoteObtainIncomeResult.Error -> ObtainIncomeData.Success(
                            startDate = startDate,
                            endDate = endDate,
                            allIncome = calculateAllIncome(emptyList()),
                            transactions = emptyList()
                        )
                        is RemoteObtainIncomeResult.Success -> {
                            // Сохраняем полученные данные локально
                            try {
                                remoteResult.transactions.forEach { transaction ->
                                    offlineTransactionRepository.insertTransaction(transaction)
                                }
                            } catch (e: Exception) {
                                // Игнорируем ошибки сохранения
                            }
                            
                            ObtainIncomeData.Success(
                                startDate = startDate,
                                endDate = endDate,
                                allIncome = calculateAllIncome(remoteResult.transactions),
                                transactions = remoteResult.transactions
                            )
                        }
                    }
                }
            }
        } catch (e: Exception) {
            ObtainIncomeData.Success(
                startDate = startDate,
                endDate = endDate,
                allIncome = calculateAllIncome(emptyList()),
                transactions = emptyList()
            )
        }
    }
    
    private fun filterTransactionsByDate(transactions: List<Transaction>, startDate: String, endDate: String): List<Transaction> {
        return try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val start = dateFormat.parse(startDate)
            val end = dateFormat.parse(endDate)
            
            transactions.filter { transaction ->
                try {
                    val transactionDate = dateFormat.parse(transaction.transactionDate.take(10))
                    transactionDate != null && 
                    (transactionDate.after(start) || transactionDate == start) &&
                    (transactionDate.before(end) || transactionDate == end)
                } catch (e: Exception) {
                    false
                }
            }
        } catch (e: Exception) {
            transactions
        }
    }
    
    private fun isNetworkAvailable(): Boolean {
        return try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
            capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun createIncome(createIncomeRequest: CreateIncomeRequest): ObtainCreateIncomeResult {
        return try {
            // Создаем транзакцию для локального сохранения
            val transaction = createIncomeRequest.toTransaction()
            
            // Сначала сохраняем локально
            offlineTransactionRepository.insertTransaction(transaction)
            
            // Если есть интернет - пробуем отправить на сервер
            if (isNetworkAvailable()) {
                try {
                    val remoteResult = remoteIncomeFeatureRepository.createIncome(createIncomeRequest)
                    when (remoteResult) {
                        RemoteObtainCreateIncomeResult.Error -> {
                            // Сервер недоступен, но локально сохранили
                            ObtainCreateIncomeResult.Success
                        }
                        is RemoteObtainCreateIncomeResult.Success -> ObtainCreateIncomeResult.Success
                    }
                } catch (e: Exception) {
                    // Ошибка сети, но локально сохранили
                    ObtainCreateIncomeResult.Success
                }
            } else {
                // Нет интернета, но локально сохранили
                ObtainCreateIncomeResult.Success
            }
        } catch (e: Exception) {
            ObtainCreateIncomeResult.Error
        }
    }
    
    private fun CreateIncomeRequest.toTransaction(): Transaction {
        val currentTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).format(Date())
        return Transaction(
            id = generateLocalId(),
            account = Account(
                id = this.accountId,
                name = "Account", // Можно получить из accountRepository если нужно
                balance = "0.00",
                currency = "₽"
            ),
            category = Category(
                id = this.categoryId,
                name = "Income", // Можно получить из других источников если нужно
                emoji = "💰",
                isIncome = true
            ),
            amount = this.amount,
            transactionDate = this.transactionDate,
            comment = this.comment,
            createdAt = currentTime,
            updatedAt = currentTime
        )
    }
    
    private fun generateLocalId(): Int {
        return -(System.currentTimeMillis() % Int.MAX_VALUE).toInt()
    }

    override suspend fun getTransactionById(transactionId: Int): ObtainTransactionResult {
        return try {
            // Сначала ищем локально
            val localTransaction = offlineTransactionRepository.getTransactionById(transactionId)
            if (localTransaction != null) {
                return ObtainTransactionResult.Success(localTransaction)
            }
            
            // Если не найдено локально и есть интернет - ищем на сервере
            if (isNetworkAvailable()) {
                val remoteResult = remoteIncomeFeatureRepository.getTransactionById(transactionId)
                when (remoteResult) {
                    RemoteObtainTransactionResult.Error -> ObtainTransactionResult.Error
                    is RemoteObtainTransactionResult.Success -> {
                        // Сохраняем найденную транзакцию локально
                        try {
                            offlineTransactionRepository.insertTransaction(remoteResult.transaction)
                        } catch (e: Exception) {
                            // Игнорируем ошибки сохранения
                        }
                        ObtainTransactionResult.Success(remoteResult.transaction)
                    }
                }
            } else {
                ObtainTransactionResult.Error
            }
        } catch (e: Exception) {
            ObtainTransactionResult.Error
        }
    }

    override suspend fun updateIncome(transactionId: Int, createIncomeRequest: CreateIncomeRequest): ObtainUpdateIncomeResult {
        return try {
            // Получаем существующую транзакцию
            val existingTransaction = offlineTransactionRepository.getTransactionById(transactionId)
            if (existingTransaction != null) {
                // Обновляем локально
                val updatedTransaction = existingTransaction.copy(
                    amount = createIncomeRequest.amount,
                    comment = createIncomeRequest.comment,
                    transactionDate = createIncomeRequest.transactionDate,
                    updatedAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).format(Date())
                )
                offlineTransactionRepository.updateTransaction(updatedTransaction)
                
                // Если есть интернет - пробуем обновить на сервере
                if (isNetworkAvailable()) {
                    try {
                        val remoteResult = remoteIncomeFeatureRepository.updateIncome(transactionId, createIncomeRequest)
                        // Игнорируем результат сервера, главное что локально обновили
                    } catch (e: Exception) {
                        // Игнорируем ошибки сети
                    }
                }
                
                ObtainUpdateIncomeResult.Success
            } else {
                ObtainUpdateIncomeResult.Error
            }
        } catch (e: Exception) {
            ObtainUpdateIncomeResult.Error
        }
    }
}