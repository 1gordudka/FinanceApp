package com.finance.outcome.presentation.screens.main.di

import com.finance.outcome.presentation.screens.main.OutcomeMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class OutcomeScreenModule {

    @OutcomeScreenComponentScope
    @Provides
    fun provideOutcomeMainScreenViewModel(): OutcomeMainScreenViewModel =
        OutcomeMainScreenViewModel()
}
