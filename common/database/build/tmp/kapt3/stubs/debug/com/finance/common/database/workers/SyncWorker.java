package com.finance.common.database.workers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/finance/common/database/workers/SyncWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "offlineRepository", "Lcom/finance/common/database/repository/OfflineTransactionRepository;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/finance/common/database/repository/OfflineTransactionRepository;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "database_debug"})
public final class SyncWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.common.database.repository.OfflineTransactionRepository offlineRepository = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_NAME = "sync_transactions_work";
    public static final long SYNC_INTERVAL_HOURS = 2L;
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.common.database.workers.SyncWorker.Companion Companion = null;
    
    public SyncWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.finance.common.database.repository.OfflineTransactionRepository offlineRepository) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/finance/common/database/workers/SyncWorker$Companion;", "", "()V", "SYNC_INTERVAL_HOURS", "", "WORK_NAME", "", "cancelPeriodicSync", "", "context", "Landroid/content/Context;", "schedulePeriodicSync", "database_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void schedulePeriodicSync(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void cancelPeriodicSync(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
}