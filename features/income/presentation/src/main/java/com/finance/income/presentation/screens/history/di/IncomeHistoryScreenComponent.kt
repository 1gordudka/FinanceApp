package com.finance.income.presentation.screens.history.di

import dagger.Subcomponent
import com.finance.income.presentation.screens.history.IncomeHistoryScreenViewModel

@IncomeHistoryScreenComponentScope
@Subcomponent(modules = [IncomeHistoryScreenModule::class])
interface IncomeHistoryScreenComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): IncomeHistoryScreenComponent
    }

    val incomeHistoryScreenViewModel: IncomeHistoryScreenViewModel
} 