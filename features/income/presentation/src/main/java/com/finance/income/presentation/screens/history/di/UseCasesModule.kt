package com.finance.income.presentation.screens.history.di

import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.use_cases.GetIncomeDataUseCase
import com.finance.income.presentation.screens.main.di.IncomeScreenComponentScope
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @IncomeHistoryScreenComponentScope
    @Provides
    fun provideGetIncomeDataUseCase(
        incomeFeatureRepository: IncomeFeatureRepository
    ): GetIncomeDataUseCase = GetIncomeDataUseCase(incomeFeatureRepository)
}