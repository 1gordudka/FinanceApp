package com.finance.income.presentation.di

import com.features.income.data.remote.network.IncomeService
import com.features.income.data.remote.repository.RemoteIncomeFeatureRepository
import com.features.income.data.remote.repository.RemoteOutcomeFeatureRepositoryImpl
import com.features.income.data.repository.IncomeFeatureRepositoryImpl
import com.finance.common.network.repository.AccountRepository
import com.finance.income.domain.repository.IncomeFeatureRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class RepositoryModule {

    @IncomeFeatureComponentScope
    @Provides
    fun provideIncomeFeatureRepository(
        accountRepository: AccountRepository,
        remoteIncomeFeatureRepository: RemoteIncomeFeatureRepository
    ): IncomeFeatureRepository = IncomeFeatureRepositoryImpl(
        accountRepository, remoteIncomeFeatureRepository
    )
}