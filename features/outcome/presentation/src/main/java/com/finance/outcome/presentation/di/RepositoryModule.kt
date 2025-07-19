package com.finance.outcome.presentation.di

import android.content.Context
import com.finance.common.database.repository.OfflineTransactionRepository
import com.finance.common.network.repository.AccountRepository
import com.finance.outcome.data.remote.repository.RemoteOutcomeFeatureRepository
import com.finance.outcome.data.repository.OutcomeFeatureRepositoryImpl
import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @OutcomeFeatureComponentScope
    @Provides
    fun provideOutcomeFeatureRepository(
        accountRepository: AccountRepository,
        remoteOutcomeFeatureRepository: RemoteOutcomeFeatureRepository,
        offlineTransactionRepository: OfflineTransactionRepository,
        context: Context
    ): OutcomeFeatureRepository = OutcomeFeatureRepositoryImpl(
        accountRepository, 
        remoteOutcomeFeatureRepository,
        offlineTransactionRepository,
        context
    )
}