package com.finance.income.presentation.screens.history.di

import com.finance.income.domain.use_cases.GetIncomeDataUseCase
import com.finance.income.presentation.screens.history.IncomeHistoryScreenViewModel
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class IncomeHistoryScreenModule {

    @IncomeHistoryScreenComponentScope
    @Provides
    fun provideIncomeHistoryScreenViewModel(
        getIncomeDataUseCase: GetIncomeDataUseCase
    ) : IncomeHistoryScreenViewModel =
        IncomeHistoryScreenViewModel(getIncomeDataUseCase)
}