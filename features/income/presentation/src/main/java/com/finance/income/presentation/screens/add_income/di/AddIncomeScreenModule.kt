package com.finance.income.presentation.screens.add_income.di

import com.finance.income.domain.use_cases.CreateIncomeUseCase
import com.finance.income.domain.use_cases.GetTransactionByIdUseCase
import com.finance.income.domain.use_cases.UpdateIncomeUseCase
import com.finance.income.presentation.screens.add_income.AddIncomeScreenViewModel
import com.finance.income.presentation.screens.add_income.models.IncomeScreenMode
import dagger.Module
import dagger.Provides

@Module(
    includes = [UseCasesModule::class]
)
class AddIncomeScreenModule(
    private val mode: IncomeScreenMode
) {

    @AddIncomeScreenComponentScope
    @Provides
    fun provideIncomeScreenMode(): IncomeScreenMode = mode

    @AddIncomeScreenComponentScope
    @Provides
    fun provideAddIncomeScreenViewModel(
        createIncomeUseCase: CreateIncomeUseCase,
        updateIncomeUseCase: UpdateIncomeUseCase,
        getTransactionByIdUseCase: GetTransactionByIdUseCase,
        mode: IncomeScreenMode
    ): AddIncomeScreenViewModel = AddIncomeScreenViewModel(
        createIncomeUseCase, updateIncomeUseCase, getTransactionByIdUseCase, mode
    )
} 