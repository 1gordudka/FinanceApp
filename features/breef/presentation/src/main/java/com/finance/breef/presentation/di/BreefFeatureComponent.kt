package com.finance.breef.presentation.di

import com.finance.breef.presentation.screens.main.di.BreefScreenComponent
import dagger.Subcomponent

@BreefFeatureComponentScope
@Subcomponent(
    modules = [BreefFeatureModule::class]
)
interface BreefFeatureComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): BreefFeatureComponent
    }

    val breefMainScreenComponentFactory: BreefScreenComponent.Factory
}
