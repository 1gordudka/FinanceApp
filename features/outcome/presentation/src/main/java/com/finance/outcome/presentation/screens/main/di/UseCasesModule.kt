package com.finance.outcome.presentation.screens.main.di

import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.use_cases.GetTodayOutcomeDataUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @OutcomeScreenComponentScope
    @Provides
    fun provideGetTodayOutcomeUseCase(
        outcomeFeatureRepository: OutcomeFeatureRepository
    ): GetTodayOutcomeDataUseCase = GetTodayOutcomeDataUseCase(outcomeFeatureRepository)
}