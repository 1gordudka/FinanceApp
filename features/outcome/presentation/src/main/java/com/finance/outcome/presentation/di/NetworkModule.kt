package com.finance.outcome.presentation.di

import com.finance.outcome.data.remote.network.OutcomeService
import com.finance.outcome.data.remote.repository.RemoteOutcomeFeatureRepository
import com.finance.outcome.data.remote.repository.RemoteOutcomeFeatureRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {

    @OutcomeFeatureComponentScope
    @Provides
    fun provideOutcomeService(retrofit: Retrofit): OutcomeService =
        retrofit.create(OutcomeService::class.java)

    @OutcomeFeatureComponentScope
    @Provides
    fun provideRemoteOutcomeFeatureRepository(
        outcomeService: OutcomeService
    ): RemoteOutcomeFeatureRepository = RemoteOutcomeFeatureRepositoryImpl(outcomeService)
}