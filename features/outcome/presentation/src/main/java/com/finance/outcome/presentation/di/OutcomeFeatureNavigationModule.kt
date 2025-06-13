package com.finance.outcome.presentation.di

import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.di.NavigationScope
import com.finance.outcome.presentation.navigation.OutcomeFeatureBottomBarItem
import com.finance.outcome.presentation.navigation.OutcomeFeatureNavigationApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class OutcomeFeatureNavigationModule {

    @NavigationScope
    @Provides
    @IntoSet
    fun provideOutcomeFeatureNavigationApi(): FeatureNavigationApi =
        OutcomeFeatureNavigationApi()

    @NavigationScope
    @Provides
    @IntoSet
    fun provideOutcomeFeatureBottomBarItem(): BottomBarItem =
        OutcomeFeatureBottomBarItem()
}
