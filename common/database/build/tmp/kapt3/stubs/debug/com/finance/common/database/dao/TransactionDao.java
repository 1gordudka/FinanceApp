package com.finance.common.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ\u001c\u0010\u001f\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ&\u0010$\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010&J.\u0010\'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010)\u00a8\u0006*"}, d2 = {"Lcom/finance/common/database/dao/TransactionDao;", "", "deleteMarkedTransactions", "", "syncState", "Lcom/finance/common/database/entities/SyncState;", "(Lcom/finance/common/database/entities/SyncState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransaction", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finance/common/database/entities/TransactionEntity;", "getIncomeTransactions", "getLastSyncTime", "", "getOutcomeTransactions", "getTransactionById", "getTransactionByServerId", "serverId", "getTransactionsByAnyOfSyncStates", "syncStates", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsBySyncState", "getUnsyncedTransactionsCount", "states", "insertTransaction", "transaction", "(Lcom/finance/common/database/entities/TransactionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTransactions", "transactions", "markTransactionAsDeleted", "(ILcom/finance/common/database/entities/SyncState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTransaction", "updateTransactionSyncState", "lastSyncTime", "(ILcom/finance/common/database/entities/SyncState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTransactionWithServerId", "localId", "(IILcom/finance/common/database/entities/SyncState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_debug"})
@androidx.room.Dao()
public abstract interface TransactionDao {
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE isDeleted = 0 ORDER BY transactionDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.common.database.entities.TransactionEntity>> getAllTransactions();
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE isIncome = 1 AND isDeleted = 0 ORDER BY transactionDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.common.database.entities.TransactionEntity>> getIncomeTransactions();
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE isIncome = 0 AND isDeleted = 0 ORDER BY transactionDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.common.database.entities.TransactionEntity>> getOutcomeTransactions();
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.common.database.entities.TransactionEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE serverId = :serverId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionByServerId(int serverId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.common.database.entities.TransactionEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE syncState = :syncState")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsBySyncState(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.SyncState syncState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finance.common.database.entities.TransactionEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE syncState IN (:syncStates)")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionsByAnyOfSyncStates(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.finance.common.database.entities.SyncState> syncStates, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finance.common.database.entities.TransactionEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.TransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTransactions(@org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.common.database.entities.TransactionEntity> transactions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.TransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE transactions SET syncState = :syncState, lastSyncTime = :lastSyncTime WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTransactionSyncState(int id, @org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.SyncState syncState, long lastSyncTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE transactions SET serverId = :serverId, syncState = :syncState, lastSyncTime = :lastSyncTime WHERE id = :localId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTransactionWithServerId(int localId, int serverId, @org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.SyncState syncState, long lastSyncTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE transactions SET isDeleted = 1, syncState = :syncState WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markTransactionAsDeleted(int id, @org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.SyncState syncState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM transactions WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTransaction(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM transactions WHERE isDeleted = 1 AND syncState = :syncState")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMarkedTransactions(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.SyncState syncState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT MAX(lastSyncTime) FROM transactions WHERE syncState = :syncState")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLastSyncTime(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.entities.SyncState syncState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM transactions WHERE syncState IN (:states)")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUnsyncedTransactionsCount(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.finance.common.database.entities.SyncState> states, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}