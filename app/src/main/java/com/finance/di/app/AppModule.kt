package com.finance.di.app

import com.finance.articles.presentation.di.ArticlesFeatureComponent
import com.finance.breef.presentation.di.BreefFeatureComponent
import com.finance.di.navigation.NavigationComponent
import com.finance.income.presentation.di.IncomeFeatureComponent
import com.finance.outcome.presentation.di.OutcomeFeatureComponent
import com.finance.settings.presentation.di.SettingsFeatureComponent
import dagger.Module

@Module(
    subcomponents = [NavigationComponent::class, IncomeFeatureComponent::class,
    OutcomeFeatureComponent::class, SettingsFeatureComponent::class, ArticlesFeatureComponent::class,
    BreefFeatureComponent::class]
)
class AppModule