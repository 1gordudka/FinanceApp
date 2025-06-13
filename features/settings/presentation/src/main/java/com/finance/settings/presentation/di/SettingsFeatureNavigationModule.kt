package com.finance.settings.presentation.di

import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.di.NavigationScope
import com.finance.settings.presentation.navigation.SettingsFeatureBottomBarItem
import com.finance.settings.presentation.navigation.SettingsFeatureNavigationApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class SettingsFeatureNavigationModule {

    @NavigationScope
    @Provides
    @IntoSet
    fun provideSettingsFeatureNavigationApi(): FeatureNavigationApi =
        SettingsFeatureNavigationApi()

    @NavigationScope
    @Provides
    @IntoSet
    fun provideSettingsFeatureBottomBarItem(): BottomBarItem =
        SettingsFeatureBottomBarItem()
}
