package com.finance.income.presentation.screens.main.di

import com.finance.income.presentation.screens.main.IncomeMainScreenViewModel
import dagger.Subcomponent

@IncomeScreenComponentScope
@Subcomponent(
    modules = [IncomeScreenModule::class]
)
interface IncomeScreenComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): IncomeScreenComponent
    }

    val incomeMainScreenViewModel: IncomeMainScreenViewModel
}