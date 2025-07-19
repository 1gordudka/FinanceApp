package com.finance.income.presentation.di

import com.finance.income.presentation.screens.add_income.di.AddIncomeScreenComponent
import com.finance.income.presentation.screens.history.di.IncomeHistoryScreenComponent
import com.finance.income.presentation.screens.main.di.IncomeScreenComponent
import dagger.Subcomponent

@IncomeFeatureComponentScope
@Subcomponent(
    modules = [IncomeFeatureModule::class]
)
interface IncomeFeatureComponent {

    @Subcomponent.Factory
    interface Factory{

        fun create(): IncomeFeatureComponent
    }


    val incomeMainScreenComponentFactory: IncomeScreenComponent.Factory
    val incomeHistoryScreenComponentFactory: IncomeHistoryScreenComponent.Factory
    val addIncomeScreenComponentFactory: AddIncomeScreenComponent.Factory
}