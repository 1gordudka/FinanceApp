package com.finance.income.presentation.screens.add_income.di

import com.finance.income.domain.repository.IncomeFeatureRepository
import com.finance.income.domain.use_cases.CreateIncomeUseCase
import com.finance.income.domain.use_cases.GetTransactionByIdUseCase
import com.finance.income.domain.use_cases.UpdateIncomeUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @AddIncomeScreenComponentScope
    @Provides
    fun provideCreateIncomeUseCase(
        incomeFeatureRepository: IncomeFeatureRepository
    ): CreateIncomeUseCase =
        CreateIncomeUseCase(incomeFeatureRepository)

    @AddIncomeScreenComponentScope
    @Provides
    fun provideUpdateIncomeUseCase(
        incomeFeatureRepository: IncomeFeatureRepository
    ): UpdateIncomeUseCase =
        UpdateIncomeUseCase(incomeFeatureRepository)

    @AddIncomeScreenComponentScope
    @Provides
    fun provideGetTransactionByIdUseCase(
        incomeFeatureRepository: IncomeFeatureRepository
    ): GetTransactionByIdUseCase =
        GetTransactionByIdUseCase(incomeFeatureRepository)
} 