package com.finance.outcome.presentation.screens.history.di

import com.finance.outcome.presentation.screens.history.OutcomeHistoryScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class OutcomeHistoryScreenModule {

    @OutcomeHistoryScreenComponentScope
    @Provides
    fun provideOutcomeHistoryScreenViewModel(): OutcomeHistoryScreenViewModel =
        OutcomeHistoryScreenViewModel()
}