package com.finance.common.database.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\nH\u0082@\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\fH\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0016J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013H\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0016J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0016J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u001c\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010#\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010$\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010%\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010&\u001a\u00020\nH\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\'\u001a\b\u0012\u0004\u0012\u00020\n0(H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b)\u0010\u000fJ\u0016\u0010*\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u001fJ/\u0010+\u001a\u00020\u0016*\u00020\u00142\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\fH\u0002\u00a2\u0006\u0002\u00100R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u00061"}, d2 = {"Lcom/finance/common/database/repository/OfflineTransactionRepositoryImpl;", "Lcom/finance/common/database/repository/OfflineTransactionRepository;", "transactionDao", "Lcom/finance/common/database/dao/TransactionDao;", "context", "Landroid/content/Context;", "(Lcom/finance/common/database/dao/TransactionDao;Landroid/content/Context;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "deleteTransaction", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchServerUpdates", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateLocalId", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finance/domain/transaction/Transaction;", "getConflictedTransactions", "Lcom/finance/common/database/entities/TransactionEntity;", "getIncomeTransactions", "getLastSyncTime", "", "getOutcomeTransactions", "getTransactionById", "getUnsyncedTransactionsCount", "insertTransaction", "transaction", "(Lcom/finance/domain/transaction/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNetworkAvailable", "", "markForDelete", "markForUpdate", "resolveConflicts", "saveForLaterSync", "syncPendingTransactions", "syncTransactions", "Lkotlin/Result;", "syncTransactions-IoAF18A", "updateTransaction", "toEntity", "syncState", "Lcom/finance/common/database/entities/SyncState;", "lastSyncTime", "serverId", "(Lcom/finance/domain/transaction/Transaction;Lcom/finance/common/database/entities/SyncState;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/finance/common/database/entities/TransactionEntity;", "database_debug"})
public final class OfflineTransactionRepositoryImpl implements com.finance.common.database.repository.OfflineTransactionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.common.database.dao.TransactionDao transactionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    
    @javax.inject.Inject()
    public OfflineTransactionRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.dao.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.finance.domain.transaction.Transaction>> getAllTransactions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.finance.domain.transaction.Transaction>> getIncomeTransactions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.finance.domain.transaction.Transaction>> getOutcomeTransactions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTransactionById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.domain.transaction.Transaction> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteTransaction(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUnsyncedTransactionsCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLastSyncTime(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveForLaterSync(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object markForUpdate(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object markForDelete(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object resolveConflicts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getConflictedTransactions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finance.common.database.entities.TransactionEntity>> $completion) {
        return null;
    }
    
    private final java.lang.Object syncPendingTransactions(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object fetchServerUpdates(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean isNetworkAvailable() {
        return false;
    }
    
    private final com.finance.common.database.entities.TransactionEntity toEntity(com.finance.domain.transaction.Transaction $this$toEntity, com.finance.common.database.entities.SyncState syncState, java.lang.Long lastSyncTime, java.lang.Integer serverId) {
        return null;
    }
    
    private final int generateLocalId() {
        return 0;
    }
}