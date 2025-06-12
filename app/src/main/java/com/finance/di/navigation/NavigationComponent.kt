package com.finance.di.navigation

import com.finance.articles.presentation.di.ArticlesFeatureNavigationModule
import com.finance.breef.presentation.di.BreefFeatureNavigationModule
import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.di.NavigationScope
import com.finance.income.presentation.di.IncomeFeatureComponent
import com.finance.income.presentation.di.IncomeFeatureNavigationModule
import com.finance.outcome.presentation.di.OutcomeFeatureNavigationModule
import com.finance.settings.presentation.di.SettingsFeatureNavigationModule
import dagger.Subcomponent


@NavigationScope
@Subcomponent(
    modules = [IncomeFeatureNavigationModule::class, OutcomeFeatureNavigationModule::class,
        SettingsFeatureNavigationModule::class, BreefFeatureNavigationModule::class,
        ArticlesFeatureNavigationModule::class]
)
interface NavigationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NavigationComponent
    }

    val bottomBarItems: Set<@JvmSuppressWildcards BottomBarItem>

    val featureNavigationApi: Set<@JvmSuppressWildcards FeatureNavigationApi>
}