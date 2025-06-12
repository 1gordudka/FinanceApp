package com.finance.settings.presentation.screens.main.di

import com.finance.settings.presentation.screens.main.SettingsMainScreenViewModel
import dagger.Subcomponent

@SettingsScreenComponentScope
@Subcomponent(
    modules = [SettingsScreenModule::class]
)
interface SettingsScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SettingsScreenComponent
    }

    val settingsMainScreenViewModel: SettingsMainScreenViewModel
}
