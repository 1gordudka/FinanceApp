package com.finance.income.presentation.screens.main.di

import com.finance.income.presentation.di.IncomeFeatureComponentScope
import com.finance.income.presentation.screens.main.IncomeMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class IncomeScreenModule {

    @IncomeScreenComponentScope
    @Provides
    fun provideIncomeMainScreenViewModel(): IncomeMainScreenViewModel =
        IncomeMainScreenViewModel()
}