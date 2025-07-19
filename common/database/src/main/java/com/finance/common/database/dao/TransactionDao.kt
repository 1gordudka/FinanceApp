package com.finance.common.database.dao

import androidx.room.*
import com.finance.common.database.entities.SyncState
import com.finance.common.database.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    
    @Query("SELECT * FROM transactions WHERE isDeleted = 0 ORDER BY transactionDate DESC")
    fun getAllTransactions(): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE isIncome = 1 AND isDeleted = 0 ORDER BY transactionDate DESC")
    fun getIncomeTransactions(): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE isIncome = 0 AND isDeleted = 0 ORDER BY transactionDate DESC")
    fun getOutcomeTransactions(): Flow<List<TransactionEntity>>
    
    @Query("SELECT * FROM transactions WHERE id = :id")
    suspend fun getTransactionById(id: Int): TransactionEntity?
    
    @Query("SELECT * FROM transactions WHERE serverId = :serverId")
    suspend fun getTransactionByServerId(serverId: Int): TransactionEntity?
    
    @Query("SELECT * FROM transactions WHERE syncState = :syncState")
    suspend fun getTransactionsBySyncState(syncState: SyncState): List<TransactionEntity>
    
    @Query("SELECT * FROM transactions WHERE syncState IN (:syncStates)")
    suspend fun getTransactionsByAnyOfSyncStates(syncStates: List<SyncState>): List<TransactionEntity>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: TransactionEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactions(transactions: List<TransactionEntity>)
    
    @Update
    suspend fun updateTransaction(transaction: TransactionEntity)
    
    @Query("UPDATE transactions SET syncState = :syncState, lastSyncTime = :lastSyncTime WHERE id = :id")
    suspend fun updateTransactionSyncState(id: Int, syncState: SyncState, lastSyncTime: Long)
    
    @Query("UPDATE transactions SET serverId = :serverId, syncState = :syncState, lastSyncTime = :lastSyncTime WHERE id = :localId")
    suspend fun updateTransactionWithServerId(localId: Int, serverId: Int, syncState: SyncState, lastSyncTime: Long)
    
    @Query("UPDATE transactions SET isDeleted = 1, syncState = :syncState WHERE id = :id")
    suspend fun markTransactionAsDeleted(id: Int, syncState: SyncState)
    
    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun deleteTransaction(id: Int)
    
    @Query("DELETE FROM transactions WHERE isDeleted = 1 AND syncState = :syncState")
    suspend fun deleteMarkedTransactions(syncState: SyncState)
    
    @Query("SELECT MAX(lastSyncTime) FROM transactions WHERE syncState = :syncState")
    suspend fun getLastSyncTime(syncState: SyncState): Long?
    
    @Query("SELECT COUNT(*) FROM transactions WHERE syncState IN (:states)")
    suspend fun getUnsyncedTransactionsCount(states: List<SyncState>): Int
} 