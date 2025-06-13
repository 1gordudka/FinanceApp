package com.finance.outcome.presentation.screens.main.di

import com.finance.outcome.presentation.screens.main.OutcomeMainScreenViewModel
import dagger.Subcomponent

@OutcomeScreenComponentScope
@Subcomponent(
    modules = [OutcomeScreenModule::class]
)
interface OutcomeScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): OutcomeScreenComponent
    }

    val outcomeMainScreenViewModel: OutcomeMainScreenViewModel
}
