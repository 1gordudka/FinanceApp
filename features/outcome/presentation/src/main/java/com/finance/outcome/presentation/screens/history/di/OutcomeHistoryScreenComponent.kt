package com.finance.outcome.presentation.screens.history.di

import com.finance.outcome.presentation.screens.history.OutcomeHistoryScreenViewModel
import dagger.Subcomponent


@OutcomeHistoryScreenComponentScope
@Subcomponent(
    modules = [OutcomeHistoryScreenModule::class]
)
interface OutcomeHistoryScreenComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): OutcomeHistoryScreenComponent
    }

    val outcomeHistoryScreenViewModel: OutcomeHistoryScreenViewModel
}