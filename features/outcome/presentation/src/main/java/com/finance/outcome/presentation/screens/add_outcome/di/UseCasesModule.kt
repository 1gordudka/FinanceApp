package com.finance.outcome.presentation.screens.add_outcome.di

import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.use_cases.CreateOutcomeUseCase
import com.finance.outcome.domain.use_cases.GetTransactionByIdUseCase
import com.finance.outcome.domain.use_cases.UpdateOutcomeUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @AddOutcomeScreenComponentScope
    @Provides
    fun provideCreateOutcomeUseCase(
        outcomeFeatureRepository: OutcomeFeatureRepository
    ): CreateOutcomeUseCase =
        CreateOutcomeUseCase(outcomeFeatureRepository)

    @AddOutcomeScreenComponentScope
    @Provides
    fun provideUpdateOutcomeUseCase(
        outcomeFeatureRepository: OutcomeFeatureRepository
    ): UpdateOutcomeUseCase =
        UpdateOutcomeUseCase(outcomeFeatureRepository)

    @AddOutcomeScreenComponentScope
    @Provides
    fun provideGetTransactionByIdUseCase(
        outcomeFeatureRepository: OutcomeFeatureRepository
    ): GetTransactionByIdUseCase =
        GetTransactionByIdUseCase(outcomeFeatureRepository)
} 