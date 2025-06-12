package com.finance.breef.presentation.di

import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.di.NavigationScope
import com.finance.breef.presentation.navigation.BreefFeatureBottomBarItem
import com.finance.breef.presentation.navigation.BreefFeatureNavigationApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class BreefFeatureNavigationModule {

    @NavigationScope
    @Provides
    @IntoSet
    fun provideBreefFeatureNavigationApi(): FeatureNavigationApi =
        BreefFeatureNavigationApi()

    @NavigationScope
    @Provides
    @IntoSet
    fun provideBreefFeatureBottomBarItem(): BottomBarItem =
        BreefFeatureBottomBarItem()
}
