package com.finance.outcome.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.finance.common.database.repository.OfflineTransactionRepository
import com.finance.common.network.repository.AccountRepository
import com.finance.common.network.results.ObtainAccountId
import com.finance.domain.transaction.Account
import com.finance.domain.transaction.Category
import com.finance.domain.transaction.Transaction
import com.finance.outcome.data.remote.mappers.calculateAllOutcome
import com.finance.outcome.data.remote.repository.RemoteOutcomeFeatureRepository
import com.finance.outcome.data.remote.results.RemoteObtainCreateOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainOutcomeResult
import com.finance.outcome.data.remote.results.RemoteObtainTransactionResult
import com.finance.outcome.domain.models.CreateOutcomeRequest
import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.results.ObtainCreateOutcomeResult
import com.finance.outcome.domain.results.ObtainOutcomeData
import com.finance.outcome.domain.results.ObtainTransactionResult
import com.finance.outcome.domain.results.ObtainUpdateOutcomeResult
import kotlinx.coroutines.flow.first
import java.text.SimpleDateFormat
import java.util.*

class OutcomeFeatureRepositoryImpl(
    private val accountRepository: AccountRepository,
    private val remoteOutcomeFeatureRepository: RemoteOutcomeFeatureRepository,
    private val offlineTransactionRepository: OfflineTransactionRepository,
    private val context: Context
) : OutcomeFeatureRepository {
    override suspend fun getOutcomeData(startDate: String, endDate: String): ObtainOutcomeData {
        return try {
            // Всегда сначала пробуем загрузить из локальной БД
            val localTransactions = offlineTransactionRepository.getOutcomeTransactions().first()
            
            if (localTransactions.isNotEmpty()) {
                // Если есть локальные данные - возвращаем их (с фильтрацией или без)
                val filteredTransactions = filterTransactionsByDate(localTransactions, startDate, endDate)
                
                ObtainOutcomeData.Success(
                    startDate = startDate,
                    endDate = endDate,
                    allOutcome = calculateAllOutcome(filteredTransactions),
                    transactions = filteredTransactions
                )
            } else {
                // Локальных данных нет - пробуем загрузить с сети (только если есть интернет)
                if (isNetworkAvailable()) {
                    loadFromNetworkAndSave(startDate, endDate)
                } else {
                    // Нет интернета и нет локальных данных - возвращаем пустой результат
                    ObtainOutcomeData.Success(
                        startDate = startDate,
                        endDate = endDate,
                        allOutcome = calculateAllOutcome(emptyList()),
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
                    ObtainOutcomeData.Success(
                        startDate = startDate,
                        endDate = endDate,
                        allOutcome = calculateAllOutcome(emptyList()),
                        transactions = emptyList()
                    )
                }
            } else {
                ObtainOutcomeData.Success(
                    startDate = startDate,
                    endDate = endDate,
                    allOutcome = calculateAllOutcome(emptyList()),
                    transactions = emptyList()
                )
            }
        }
    }
    
    private suspend fun loadFromNetworkAndSave(startDate: String, endDate: String): ObtainOutcomeData {
        return try {
            val resultId = accountRepository.getAccountId()
            when (resultId) {
                ObtainAccountId.Error -> ObtainOutcomeData.Success(
                    startDate = startDate,
                    endDate = endDate,
                    allOutcome = calculateAllOutcome(emptyList()),
                    transactions = emptyList()
                )
                is ObtainAccountId.Success -> {
                    val remoteResult = remoteOutcomeFeatureRepository.getOutcomeData(resultId.id, startDate, endDate)
                    when (remoteResult) {
                        RemoteObtainOutcomeResult.Error -> ObtainOutcomeData.Success(
                            startDate = startDate,
                            endDate = endDate,
                            allOutcome = calculateAllOutcome(emptyList()),
                            transactions = emptyList()
                        )
                        is RemoteObtainOutcomeResult.Success -> {
                            // Сохраняем полученные данные локально
                            try {
                                remoteResult.transactions.forEach { transaction ->
                                    offlineTransactionRepository.insertTransaction(transaction)
                                }
                            } catch (e: Exception) {
                                // Игнорируем ошибки сохранения
                            }
                            
                            ObtainOutcomeData.Success(
                                startDate = startDate,
                                endDate = endDate,
                                allOutcome = calculateAllOutcome(remoteResult.transactions),
                                transactions = remoteResult.transactions
                            )
                        }
                    }
                }
            }
        } catch (e: Exception) {
            ObtainOutcomeData.Success(
                startDate = startDate,
                endDate = endDate,
                allOutcome = calculateAllOutcome(emptyList()),
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

    override suspend fun createOutcome(createOutcomeRequest: CreateOutcomeRequest): ObtainCreateOutcomeResult {
        return try {
            // Создаем транзакцию для локального сохранения
            val transaction = createOutcomeRequest.toTransaction()
            
            // Сначала сохраняем локально
            offlineTransactionRepository.insertTransaction(transaction)
            
            // Если есть интернет - пробуем отправить на сервер
            if (isNetworkAvailable()) {
                try {
                    val remoteResult = remoteOutcomeFeatureRepository.createOutcome(createOutcomeRequest)
                    when (remoteResult) {
                        RemoteObtainCreateOutcomeResult.Error -> {
                            // Сервер недоступен, но локально сохранили
                            ObtainCreateOutcomeResult.Success
                        }
                        is RemoteObtainCreateOutcomeResult.Success -> ObtainCreateOutcomeResult.Success
                    }
                } catch (e: Exception) {
                    // Ошибка сети, но локально сохранили
                    ObtainCreateOutcomeResult.Success
                }
            } else {
                // Нет интернета, но локально сохранили
                ObtainCreateOutcomeResult.Success
            }
        } catch (e: Exception) {
            ObtainCreateOutcomeResult.Error
        }
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
                val remoteResult = remoteOutcomeFeatureRepository.getTransactionById(transactionId)
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

    override suspend fun updateOutcome(transactionId: Int, createOutcomeRequest: CreateOutcomeRequest): ObtainUpdateOutcomeResult {
        return try {
            // Получаем существующую транзакцию
            val existingTransaction = offlineTransactionRepository.getTransactionById(transactionId)
            if (existingTransaction != null) {
                // Обновляем локально
                val updatedTransaction = existingTransaction.copy(
                    amount = createOutcomeRequest.amount,
                    comment = createOutcomeRequest.comment,
                    transactionDate = createOutcomeRequest.transactionDate,
                    updatedAt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).format(Date())
                )
                offlineTransactionRepository.updateTransaction(updatedTransaction)
                
                // Если есть интернет - пробуем обновить на сервере
                if (isNetworkAvailable()) {
                    try {
                        val remoteResult = remoteOutcomeFeatureRepository.updateOutcome(transactionId, createOutcomeRequest)
                        // Игнорируем результат сервера, главное что локально обновили
                    } catch (e: Exception) {
                        // Игнорируем ошибки сети
                    }
                }
                
                ObtainUpdateOutcomeResult.Success
            } else {
                ObtainUpdateOutcomeResult.Error
            }
        } catch (e: Exception) {
            ObtainUpdateOutcomeResult.Error
        }
    }
    
    private fun CreateOutcomeRequest.toTransaction(): Transaction {
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
                name = "Outcome", // Можно получить из других источников если нужно
                emoji = "💸",
                isIncome = false
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
}