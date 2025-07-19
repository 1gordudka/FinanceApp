package com.finance.di.app

import android.content.Context
import com.finance.articles.presentation.di.ArticlesFeatureComponent
import com.finance.brief.presentation.di.BriefFeatureComponent
import com.finance.common.database.demo.DemoDataManager
import com.finance.common.database.workers.DaggerWorkerFactory
import com.finance.common.network.repository.AccountRepository
import com.finance.di.navigation.NavigationComponent
import com.finance.income.presentation.di.IncomeFeatureComponent
import com.finance.outcome.presentation.di.OutcomeFeatureComponent
import com.finance.settings.presentation.di.SettingsFeatureComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    val navigationComponentFactory: NavigationComponent.Factory

    fun accountRepository(): AccountRepository
    fun daggerWorkerFactory(): DaggerWorkerFactory
    fun demoDataManager(): DemoDataManager

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): AppComponent
    }

    val incomeFeatureComponentFactory: IncomeFeatureComponent.Factory
    val outcomeComponentFactory: OutcomeFeatureComponent.Factory
    val briefComponentFactory: BriefFeatureComponent.Factory
    val settingsComponentFactory: SettingsFeatureComponent.Factory
    val articleComponentFactory: ArticlesFeatureComponent.Factory

}