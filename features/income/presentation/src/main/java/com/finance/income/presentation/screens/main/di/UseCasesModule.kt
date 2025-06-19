package com.finance.income.presentation.screens.main.di

import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.use_cases.GetTodayIncomeUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @IncomeScreenComponentScope
    @Provides
    fun provideGetTodayIncomeUseCase(
        incomeFeatureRepository: IncomeFeatureRepository
    ): GetTodayIncomeUseCase = GetTodayIncomeUseCase(incomeFeatureRepository)
}