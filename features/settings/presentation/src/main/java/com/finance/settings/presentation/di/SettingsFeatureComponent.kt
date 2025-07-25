package com.finance.settings.presentation.di

import com.finance.settings.data.sync.SyncFrequencyManager
import com.finance.settings.domain.usecase.SettingsUseCases
import com.finance.settings.presentation.screens.main.di.SettingsScreenComponent
import dagger.Subcomponent

@Subcomponent(
    modules = [SettingsFeatureModule::class, SettingsFeatureNavigationModule::class, SettingsFeatureDependenciesModule::class]
)
interface SettingsFeatureComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsFeatureComponent
    }

    val settingsMainScreenComponentFactory: SettingsScreenComponent.Factory
    val settingsUseCases: SettingsUseCases
    val syncFrequencyManager: SyncFrequencyManager
}
