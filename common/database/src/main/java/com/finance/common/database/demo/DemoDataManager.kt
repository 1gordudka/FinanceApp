package com.finance.common.database.demo

import android.content.Context
import android.content.SharedPreferences
import com.finance.common.database.entities.SyncState
import com.finance.common.database.entities.TransactionEntity
import com.finance.common.database.repository.OfflineTransactionRepository
import com.finance.domain.transaction.Account
import com.finance.domain.transaction.Category
import com.finance.domain.transaction.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DemoDataManager @Inject constructor(
    private val context: Context,
    private val offlineRepository: OfflineTransactionRepository
) {
    
    private val prefs: SharedPreferences = context.getSharedPreferences("demo_data", Context.MODE_PRIVATE)
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    
    fun initializeDemoDataIfNeeded() {
        if (!prefs.getBoolean("demo_data_initialized", false)) {
            CoroutineScope(Dispatchers.IO).launch {
                createDemoTransactions()
                prefs.edit().putBoolean("demo_data_initialized", true).apply()
            }
        }
    }
    
    private suspend fun createDemoTransactions() {
        val currentTime = dateFormat.format(Date())
        val account = Account(
            id = 1,
            name = "Основной счет",
            balance = "50000.00",
            currency = "₽"
        )
        
        // Минимальные демо данные для тестирования офлайна
        val transactions = listOf(
            Transaction(
                id = 1,
                account = account,
                category = Category(1, "Зарплата", "💰", true),
                amount = "45000.00",
                transactionDate = getDateDaysAgo(0), // Сегодня
                comment = "Демо доход",
                createdAt = currentTime,
                updatedAt = currentTime
            ),
            Transaction(
                id = 2,
                account = account,
                category = Category(2, "Продукты", "🛒", false),
                amount = "3500.00",
                transactionDate = getDateDaysAgo(0), // Сегодня
                comment = "Демо расход",
                createdAt = currentTime,
                updatedAt = currentTime
            )
        )
        
        // Сохраняем как локальные данные
        transactions.forEach { transaction ->
            offlineRepository.insertTransaction(transaction)
        }
    }
    
    private fun getDateDaysAgo(daysAgo: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -daysAgo)
        return dateFormat.format(calendar.time)
    }
} 