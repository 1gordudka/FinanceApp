package com.finance.settings.presentation.screens.main.di

import com.finance.common.database.sync.SyncStatusManager
import com.finance.settings.presentation.screens.main.SettingsMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class SettingsScreenModule {

    @SettingsScreenComponentScope
    @Provides
    fun provideSettingsMainScreenViewModel(
        syncStatusManager: SyncStatusManager
    ): SettingsMainScreenViewModel =
        SettingsMainScreenViewModel(syncStatusManager)
}
