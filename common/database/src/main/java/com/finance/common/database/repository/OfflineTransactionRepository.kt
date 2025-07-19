package com.finance.common.database.repository

import com.finance.common.database.entities.SyncState
import com.finance.common.database.entities.TransactionEntity
import com.finance.domain.transaction.Transaction
import kotlinx.coroutines.flow.Flow

interface OfflineTransactionRepository {
    
    // Local operations
    fun getAllTransactions(): Flow<List<Transaction>>
    fun getIncomeTransactions(): Flow<List<Transaction>>
    fun getOutcomeTransactions(): Flow<List<Transaction>>
    suspend fun getTransactionById(id: Int): Transaction?
    
    suspend fun insertTransaction(transaction: Transaction): Long
    suspend fun updateTransaction(transaction: Transaction)
    suspend fun deleteTransaction(id: Int)
    
    // Sync operations
    suspend fun syncTransactions(): Result<Unit>
    suspend fun getUnsyncedTransactionsCount(): Int
    suspend fun getLastSyncTime(): Long?
    
    // Offline operations
    suspend fun saveForLaterSync(transaction: Transaction): Long
    suspend fun markForUpdate(transaction: Transaction)
    suspend fun markForDelete(id: Int)
    
    // Conflict resolution
    suspend fun resolveConflicts()
    suspend fun getConflictedTransactions(): List<TransactionEntity>
} 