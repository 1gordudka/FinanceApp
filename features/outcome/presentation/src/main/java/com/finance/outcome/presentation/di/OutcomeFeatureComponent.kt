package com.finance.outcome.presentation.di

import com.finance.outcome.presentation.screens.add_outcome.di.AddOutcomeScreenComponent
import com.finance.outcome.presentation.screens.history.di.OutcomeHistoryScreenComponent
import com.finance.outcome.presentation.screens.main.di.OutcomeScreenComponent
import dagger.Subcomponent

@OutcomeFeatureComponentScope
@Subcomponent(
    modules = [OutcomeFeatureModule::class]
)
interface OutcomeFeatureComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): OutcomeFeatureComponent
    }

    val outcomeMainScreenComponentFactory: OutcomeScreenComponent.Factory
    val outcomeHistoryScreenComponentFactory: OutcomeHistoryScreenComponent.Factory
    val addOutcomeScreenComponentFactory: AddOutcomeScreenComponent.Factory
}
