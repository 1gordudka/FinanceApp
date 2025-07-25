package com.finance.common.database;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/finance/common/database/DatabaseModule;", "", "()V", "provideDemoDataManager", "Lcom/finance/common/database/demo/DemoDataManager;", "context", "Landroid/content/Context;", "offlineRepository", "Lcom/finance/common/database/repository/OfflineTransactionRepository;", "provideFinanceDatabase", "Lcom/finance/common/database/FinanceDatabase;", "provideOfflineTransactionRepository", "transactionDao", "Lcom/finance/common/database/dao/TransactionDao;", "provideTransactionDao", "database", "provideWorkManager", "Landroidx/work/WorkManager;", "database_debug"})
public final class DatabaseModule {
    
    public DatabaseModule() {
        super();
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.finance.common.database.FinanceDatabase provideFinanceDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.finance.common.database.dao.TransactionDao provideTransactionDao(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.FinanceDatabase database) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.finance.common.database.repository.OfflineTransactionRepository provideOfflineTransactionRepository(@org.jetbrains.annotations.NotNull()
    com.finance.common.database.dao.TransactionDao transactionDao, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final androidx.work.WorkManager provideWorkManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.finance.common.database.demo.DemoDataManager provideDemoDataManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.finance.common.database.repository.OfflineTransactionRepository offlineRepository) {
        return null;
    }
}