package com.finance.common.database

import android.content.Context
import androidx.work.WorkManager
import com.finance.common.database.dao.TransactionDao
import com.finance.common.database.demo.DemoDataManager
import com.finance.common.database.repository.OfflineTransactionRepository
import com.finance.common.database.repository.OfflineTransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFinanceDatabase(context: Context): FinanceDatabase {
        return FinanceDatabase.getDatabase(context)
    }

    @Provides
    fun provideTransactionDao(database: FinanceDatabase): TransactionDao {
        return database.transactionDao()
    }

    @Singleton
    @Provides
    fun provideOfflineTransactionRepository(
        transactionDao: TransactionDao,
        context: Context
    ): OfflineTransactionRepository {
        return OfflineTransactionRepositoryImpl(transactionDao, context)
    }

    @Provides
    fun provideWorkManager(context: Context): WorkManager {
        return WorkManager.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideDemoDataManager(
        context: Context,
        offlineRepository: OfflineTransactionRepository
    ): DemoDataManager {
        return DemoDataManager(context, offlineRepository)
    }
 
} 