package com.finance.common.database.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0019\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\rJ\u0016\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"Lcom/finance/common/database/repository/OfflineTransactionRepository;", "", "deleteTransaction", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finance/domain/transaction/Transaction;", "getConflictedTransactions", "Lcom/finance/common/database/entities/TransactionEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncomeTransactions", "getLastSyncTime", "", "getOutcomeTransactions", "getTransactionById", "getUnsyncedTransactionsCount", "insertTransaction", "transaction", "(Lcom/finance/domain/transaction/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markForDelete", "markForUpdate", "resolveConflicts", "saveForLaterSync", "syncTransactions", "Lkotlin/Result;", "syncTransactions-IoAF18A", "updateTransaction", "database_debug"})
public abstract interface OfflineTransactionRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.domain.transaction.Transaction>> getAllTransactions();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.domain.transaction.Transaction>> getIncomeTransactions();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.domain.transaction.Transaction>> getOutcomeTransactions();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTransactionById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.domain.transaction.Transaction> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTransaction(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUnsyncedTransactionsCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLastSyncTime(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveForLaterSync(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markForUpdate(@org.jetbrains.annotations.NotNull()
    com.finance.domain.transaction.Transaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markForDelete(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resolveConflicts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getConflictedTransactions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finance.common.database.entities.TransactionEntity>> $completion);
}