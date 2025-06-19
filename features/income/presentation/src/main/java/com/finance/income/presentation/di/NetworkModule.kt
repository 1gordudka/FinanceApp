package com.finance.income.presentation.di

import com.features.income.data.remote.network.IncomeService
import com.features.income.data.remote.repository.RemoteIncomeFeatureRepository
import com.features.income.data.remote.repository.RemoteOutcomeFeatureRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {

    @IncomeFeatureComponentScope
    @Provides
    fun provideIncomeService(retrofit: Retrofit): IncomeService =
        retrofit.create(IncomeService::class.java)

    @IncomeFeatureComponentScope
    @Provides
    fun provideIncomeRemoteRepository(incomeService: IncomeService): RemoteIncomeFeatureRepository =
        RemoteOutcomeFeatureRepositoryImpl(incomeService)
}