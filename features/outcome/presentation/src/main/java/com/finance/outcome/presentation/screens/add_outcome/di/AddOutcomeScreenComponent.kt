package com.finance.outcome.presentation.screens.add_outcome.di

import com.finance.outcome.presentation.screens.add_outcome.AddOutcomeScreenViewModel
import com.finance.outcome.presentation.screens.add_outcome.models.OutcomeScreenMode
import dagger.Subcomponent

@AddOutcomeScreenComponentScope
@Subcomponent(
    modules = [AddOutcomeScreenModule::class]
)
interface AddOutcomeScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(module: AddOutcomeScreenModule): AddOutcomeScreenComponent
    }

    val addOutcomeScreenViewModel: AddOutcomeScreenViewModel
    val outcomeScreenMode: OutcomeScreenMode
} 