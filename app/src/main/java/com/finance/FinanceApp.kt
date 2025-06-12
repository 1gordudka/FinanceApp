package com.finance

import android.app.Application
import android.content.Context
import com.finance.articles.presentation.di.ArticlesFeatureComponent
import com.finance.articles.presentation.di.ArticlesFeatureComponentProvider
import com.finance.breef.presentation.di.BreefFeatureComponent
import com.finance.breef.presentation.di.BreefFeatureComponentProvider
import com.finance.di.app.AppComponent
import com.finance.di.app.DaggerAppComponent
import com.finance.income.presentation.di.IncomeFeatureComponent
import com.finance.income.presentation.di.IncomeFeatureComponentProvider
import com.finance.outcome.presentation.di.OutcomeFeatureComponent
import com.finance.outcome.presentation.di.OutcomeFeatureComponentProvider
import com.finance.settings.presentation.di.SettingsFeatureComponent
import com.finance.settings.presentation.di.SettingsFeatureComponentProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FinanceApp : Application(), IncomeFeatureComponentProvider, BreefFeatureComponentProvider,
ArticlesFeatureComponentProvider, SettingsFeatureComponentProvider,
OutcomeFeatureComponentProvider{


    private var _appComponent: AppComponent? = null

    val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            "AppComponent didn't initialize"
        }

    override fun provideIncomeFeatureComponent(): IncomeFeatureComponent =
        appComponent.incomeFeatureComponentFactory.create()

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.factory().create(this)
    }

    override fun provideBreefFeatureComponent(): BreefFeatureComponent =
        appComponent.breefComponentFactory.create()

    override fun provideArticlesFeatureComponent(): ArticlesFeatureComponent =
        appComponent.articleComponentFactory.create()

    override fun provideSettingsFeatureComponent(): SettingsFeatureComponent =
        appComponent.settingsComponentFactory.create()

    override fun provideOutcomeFeatureComponent(): OutcomeFeatureComponent =
        appComponent.outcomeComponentFactory.create()

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is FinanceApp -> appComponent
        else -> applicationContext.appComponent
    }