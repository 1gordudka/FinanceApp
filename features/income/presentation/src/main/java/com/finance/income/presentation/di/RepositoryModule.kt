package com.finance.income.presentation.di

import android.content.Context
import com.features.income.data.remote.repository.RemoteIncomeFeatureRepository
import com.features.income.data.repository.IncomeFeatureRepositoryImpl
import com.finance.common.database.repository.OfflineTransactionRepository
import com.finance.common.network.repository.AccountRepository
import com.finance.income.domain.repository.IncomeFeatureRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @IncomeFeatureComponentScope
    @Provides
    fun provideIncomeFeatureRepository(
        accountRepository: AccountRepository,
        remoteIncomeFeatureRepository: RemoteIncomeFeatureRepository,
        offlineTransactionRepository: OfflineTransactionRepository,
        context: Context
    ): IncomeFeatureRepository = IncomeFeatureRepositoryImpl(
        accountRepository, 
        remoteIncomeFeatureRepository,
        offlineTransactionRepository,
        context
    )
}