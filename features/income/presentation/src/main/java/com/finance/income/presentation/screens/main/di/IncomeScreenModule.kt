package com.finance.income.presentation.screens.main.di

import com.finance.income.domain.use_cases.GetTodayIncomeUseCase
import com.finance.income.presentation.di.IncomeFeatureComponentScope
import com.finance.income.presentation.screens.main.IncomeMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class IncomeScreenModule {

    @IncomeScreenComponentScope
    @Provides
    fun provideIncomeMainScreenViewModel(
        getTodayIncomeUseCase: GetTodayIncomeUseCase
    ): IncomeMainScreenViewModel =
        IncomeMainScreenViewModel(getTodayIncomeUseCase)
}