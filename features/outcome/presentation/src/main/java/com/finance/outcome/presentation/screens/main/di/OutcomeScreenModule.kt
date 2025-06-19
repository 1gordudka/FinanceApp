package com.finance.outcome.presentation.screens.main.di

import com.finance.outcome.domain.use_cases.GetTodayOutcomeDataUseCase
import com.finance.outcome.presentation.screens.main.OutcomeMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class OutcomeScreenModule {

    @OutcomeScreenComponentScope
    @Provides
    fun provideOutcomeMainScreenViewModel(
        getTodayOutcomeDataUseCase: GetTodayOutcomeDataUseCase
    ): OutcomeMainScreenViewModel =
        OutcomeMainScreenViewModel(getTodayOutcomeDataUseCase)
}
