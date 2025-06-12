package com.finance.settings.presentation.di

import com.finance.settings.presentation.screens.main.di.SettingsScreenComponent
import dagger.Subcomponent

@SettingsFeatureComponentScope
@Subcomponent(
    modules = [SettingsFeatureModule::class]
)
interface SettingsFeatureComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsFeatureComponent
    }

    val settingsMainScreenComponentFactory: SettingsScreenComponent.Factory
}
