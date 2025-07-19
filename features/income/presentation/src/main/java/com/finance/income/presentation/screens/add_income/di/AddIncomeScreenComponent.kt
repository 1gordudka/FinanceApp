package com.finance.income.presentation.screens.add_income.di

import com.finance.income.presentation.screens.add_income.AddIncomeScreenViewModel
import com.finance.income.presentation.screens.add_income.models.IncomeScreenMode
import dagger.Subcomponent

@AddIncomeScreenComponentScope
@Subcomponent(
    modules = [AddIncomeScreenModule::class]
)
interface AddIncomeScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(module: AddIncomeScreenModule): AddIncomeScreenComponent
    }

    val addIncomeScreenViewModel: AddIncomeScreenViewModel
    val incomeScreenMode: IncomeScreenMode
} 