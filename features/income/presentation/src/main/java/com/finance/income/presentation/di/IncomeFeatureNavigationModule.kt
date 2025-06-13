package com.finance.income.presentation.di

import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.di.NavigationScope
import com.finance.income.presentation.navigation.IncomeFeatureBottomBarItem
import com.finance.income.presentation.navigation.IncomeFeatureNavigationApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class IncomeFeatureNavigationModule {

    @NavigationScope
    @Provides
    @IntoSet
    fun provideIncomeFeatureNavigationApi(): FeatureNavigationApi =
        IncomeFeatureNavigationApi()

    @NavigationScope
    @Provides
    @IntoSet
    fun provideIncomeFeatureBottomBarItem(): BottomBarItem =
        IncomeFeatureBottomBarItem()
}