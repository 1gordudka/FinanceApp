package com.finance.outcome.presentation.screens.history.di

import com.finance.outcome.domain.use_cases.GetOutcomeDataUseCase
import com.finance.outcome.presentation.screens.history.OutcomeHistoryScreenViewModel
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class OutcomeHistoryScreenModule {

    @OutcomeHistoryScreenComponentScope
    @Provides
    fun provideOutcomeHistoryScreenViewModel(
        getOutcomeDataUseCase: GetOutcomeDataUseCase
    ): OutcomeHistoryScreenViewModel =
        OutcomeHistoryScreenViewModel(getOutcomeDataUseCase)
}