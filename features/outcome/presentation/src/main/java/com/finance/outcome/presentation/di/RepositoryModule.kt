package com.finance.outcome.presentation.di

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
        remoteOutcomeFeatureRepository: RemoteOutcomeFeatureRepository
    ): OutcomeFeatureRepository = OutcomeFeatureRepositoryImpl(
        accountRepository, remoteOutcomeFeatureRepository
    )
}