package com.finance.common.database.workers;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/finance/common/database/workers/DaggerWorkerFactory;", "Landroidx/work/WorkerFactory;", "offlineRepository", "Lcom/finance/common/database/repository/OfflineTransactionRepository;", "(Lcom/finance/common/database/repository/OfflineTransactionRepository;)V", "createWorker", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "workerClassName", "", "workerParameters", "Landroidx/work/WorkerParameters;", "database_debug"})
public final class DaggerWorkerFactory extends androidx.work.WorkerFactory {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.common.database.repository.OfflineTransactionRepository offlineRepository = null;
    
    @javax.inject.Inject()
    public DaggerWorkerFactory(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.repository.OfflineTransactionRepository offlineRepository) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public androidx.work.ListenableWorker createWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context appContext, @org.jetbrains.annotations.NotNull()
    java.lang.String workerClassName, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParameters) {
        return null;
    }
}