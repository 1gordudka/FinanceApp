package com.finance.outcome.presentation.screens.history.di

import com.finance.outcome.domain.repository.OutcomeFeatureRepository
import com.finance.outcome.domain.use_cases.GetOutcomeDataUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @OutcomeHistoryScreenComponentScope
    @Provides
    fun provideGetOutcomeDataUseCase(
        outcomeFeatureRepository: OutcomeFeatureRepository
    ): GetOutcomeDataUseCase = GetOutcomeDataUseCase(outcomeFeatureRepository)
}