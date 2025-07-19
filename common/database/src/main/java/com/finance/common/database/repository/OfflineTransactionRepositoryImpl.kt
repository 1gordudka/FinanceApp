package com.finance.common.database.repository

import android.content.Context
import android.util.Log
import com.finance.common.database.dao.TransactionDao
import com.finance.common.database.entities.SyncState
import com.finance.common.database.entities.TransactionEntity
import com.finance.domain.transaction.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfflineTransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao,
    private val context: Context
) : OfflineTransactionRepository {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    
    override fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }
    
    override fun getIncomeTransactions(): Flow<List<Transaction>> {
        return transactionDao.getIncomeTransactions().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }
    
    override fun getOutcomeTransactions(): Flow<List<Transaction>> {
        return transactionDao.getOutcomeTransactions().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }
    
    override suspend fun getTransactionById(id: Int): Transaction? {
        return transactionDao.getTransactionById(id)?.toDomainModel()
    }
    
    override suspend fun insertTransaction(transaction: Transaction): Long {
        val entity = transaction.toEntity(
            syncState = if (isNetworkAvailable()) SyncState.PENDING_SYNC else SyncState.PENDING_SYNC,
            lastSyncTime = null
        )
        return transactionDao.insertTransaction(entity)
    }
    
    override suspend fun updateTransaction(transaction: Transaction) {
        val existingEntity = transactionDao.getTransactionById(transaction.id)
        if (existingEntity != null) {
            val updatedEntity = transaction.toEntity(
                syncState = if (existingEntity.syncState == SyncState.SYNCED) SyncState.PENDING_UPDATE else existingEntity.syncState,
                lastSyncTime = existingEntity.lastSyncTime,
                serverId = existingEntity.serverId
            )
            transactionDao.updateTransaction(updatedEntity)
        }
    }
    
    override suspend fun deleteTransaction(id: Int) {
        val existingEntity = transactionDao.getTransactionById(id)
        if (existingEntity != null) {
            if (existingEntity.serverId != null) {
                // Если есть serverId, помечаем как удаленное для синхронизации
                transactionDao.markTransactionAsDeleted(id, SyncState.PENDING_DELETE)
            } else {
                // Если только локальная запись, удаляем сразу
                transactionDao.deleteTransaction(id)
            }
        }
    }
    
    override suspend fun syncTransactions(): Result<Unit> {
        return try {
            if (!isNetworkAvailable()) {
                return Result.failure(Exception("Нет подключения к интернету"))
            }
            
            // Синхронизируем несохраненные транзакции
            syncPendingTransactions()
            
            // Загружаем обновления с сервера
            fetchServerUpdates()
            
            // Разрешаем конфликты
            resolveConflicts()
            
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e("OfflineRepo", "Ошибка синхронизации", e)
            Result.failure(e)
        }
    }
    
    override suspend fun getUnsyncedTransactionsCount(): Int {
        return transactionDao.getUnsyncedTransactionsCount(
            listOf(SyncState.PENDING_SYNC, SyncState.PENDING_UPDATE, SyncState.PENDING_DELETE, SyncState.CONFLICT)
        )
    }
    
    override suspend fun getLastSyncTime(): Long? {
        return transactionDao.getLastSyncTime(SyncState.SYNCED)
    }
    
    override suspend fun saveForLaterSync(transaction: Transaction): Long {
        val entity = transaction.toEntity(
            syncState = SyncState.PENDING_SYNC,
            lastSyncTime = null
        )
        return transactionDao.insertTransaction(entity)
    }
    
    override suspend fun markForUpdate(transaction: Transaction) {
        updateTransaction(transaction)
    }
    
    override suspend fun markForDelete(id: Int) {
        deleteTransaction(id)
    }
    
    override suspend fun resolveConflicts() {
        val conflictedTransactions = transactionDao.getTransactionsBySyncState(SyncState.CONFLICT)
        
        for (transaction in conflictedTransactions) {
            // Простая стратегия: клиент всегда выигрывает
            // В реальном приложении здесь была бы более сложная логика
            val updatedEntity = transaction.copy(
                syncState = SyncState.PENDING_UPDATE,
                version = transaction.version + 1
            )
            transactionDao.updateTransaction(updatedEntity)
        }
    }
    
    override suspend fun getConflictedTransactions(): List<TransactionEntity> {
        return transactionDao.getTransactionsBySyncState(SyncState.CONFLICT)
    }
    
    private suspend fun syncPendingTransactions() {
        // Синхронизация создания
        val pendingSyncTransactions = transactionDao.getTransactionsBySyncState(SyncState.PENDING_SYNC)
        for (transaction in pendingSyncTransactions) {
            try {
                // Здесь был бы вызов API для создания транзакции
                // val serverId = apiService.createTransaction(transaction.toDomainModel()).id
                // Для демо просто помечаем как синхронизированное
                val currentTime = System.currentTimeMillis()
                transactionDao.updateTransactionSyncState(
                    transaction.id,
                    SyncState.SYNCED,
                    currentTime
                )
            } catch (e: Exception) {
                Log.e("OfflineRepo", "Ошибка создания транзакции на сервере", e)
            }
        }
        
        // Синхронизация обновлений
        val pendingUpdateTransactions = transactionDao.getTransactionsBySyncState(SyncState.PENDING_UPDATE)
        for (transaction in pendingUpdateTransactions) {
            try {
                // Здесь был бы вызов API для обновления
                // apiService.updateTransaction(transaction.serverId!!, transaction.toDomainModel())
                val currentTime = System.currentTimeMillis()
                transactionDao.updateTransactionSyncState(
                    transaction.id,
                    SyncState.SYNCED,
                    currentTime
                )
            } catch (e: Exception) {
                Log.e("OfflineRepo", "Ошибка обновления транзакции на сервере", e)
            }
        }
        
        // Синхронизация удалений
        val pendingDeleteTransactions = transactionDao.getTransactionsBySyncState(SyncState.PENDING_DELETE)
        for (transaction in pendingDeleteTransactions) {
            try {
                // Здесь был бы вызов API для удаления
                // apiService.deleteTransaction(transaction.serverId!!)
                transactionDao.deleteTransaction(transaction.id)
            } catch (e: Exception) {
                Log.e("OfflineRepo", "Ошибка удаления транзакции на сервере", e)
            }
        }
    }
    
    private suspend fun fetchServerUpdates() {
        try {
            // Здесь был бы запрос обновлений с сервера
            // val serverTransactions = apiService.getTransactionsSince(getLastSyncTime())
            // Для демо оставляем пустым
        } catch (e: Exception) {
            Log.e("OfflineRepo", "Ошибка получения обновлений с сервера", e)
        }
    }
    
    private fun isNetworkAvailable(): Boolean {
        // Простая проверка сети
        return try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) 
                as android.net.ConnectivityManager
            val activeNetwork = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
            capabilities?.hasCapability(android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
        } catch (e: Exception) {
            false
        }
    }
    
    private fun Transaction.toEntity(
        syncState: SyncState,
        lastSyncTime: Long?,
        serverId: Int? = null
    ): TransactionEntity {
        val currentTime = dateFormat.format(Date())
        return TransactionEntity(
            id = if (serverId == null) (this.id.takeIf { it > 0 } ?: generateLocalId()) else this.id,
            serverId = serverId,
            accountId = this.account.id,
            accountName = this.account.name,
            accountBalance = this.account.balance,
            accountCurrency = this.account.currency,
            categoryId = this.category.id,
            categoryName = this.category.name,
            categoryEmoji = this.category.emoji,
            isIncome = this.category.isIncome,
            amount = this.amount,
            transactionDate = this.transactionDate,
            comment = this.comment,
            createdAt = this.createdAt.ifEmpty { currentTime },
            updatedAt = currentTime,
            lastSyncTime = lastSyncTime,
            syncState = syncState
        )
    }
    
    private fun generateLocalId(): Int {
        // Генерируем отрицательный ID для локальных записей
        return -(System.currentTimeMillis() % Int.MAX_VALUE).toInt()
    }
} 