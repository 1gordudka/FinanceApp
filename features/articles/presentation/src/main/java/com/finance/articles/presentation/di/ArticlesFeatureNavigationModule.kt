package com.finance.articles.presentation.di

import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.di.NavigationScope
import com.finance.articles.presentation.navigation.ArticlesFeatureBottomBarItem
import com.finance.articles.presentation.navigation.ArticlesFeatureNavigationApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class ArticlesFeatureNavigationModule {

    @NavigationScope
    @Provides
    @IntoSet
    fun provideArticlesFeatureNavigationApi(): FeatureNavigationApi =
        ArticlesFeatureNavigationApi()

    @NavigationScope
    @Provides
    @IntoSet
    fun provideArticlesFeatureBottomBarItem(): BottomBarItem =
        ArticlesFeatureBottomBarItem()
}
