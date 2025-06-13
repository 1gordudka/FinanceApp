package com.finance.brief.presentation.di

import com.finance.brief.presentation.navigation.BriefFeatureBottomBarItem
import com.finance.brief.presentation.navigation.BriefFeatureNavigationApi
import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.di.NavigationScope
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class BriefFeatureNavigationModule {

    @NavigationScope
    @Provides
    @IntoSet
    fun provideBriefFeatureNavigationApi(): FeatureNavigationApi =
        BriefFeatureNavigationApi()

    @NavigationScope
    @Provides
    @IntoSet
    fun provideBriefFeatureBottomBarItem(): BottomBarItem =
        BriefFeatureBottomBarItem()
}
