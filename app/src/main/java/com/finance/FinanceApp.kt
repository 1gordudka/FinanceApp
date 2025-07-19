package com.finance

import android.app.Application
import android.content.Context
import androidx.work.Configuration
import com.finance.articles.presentation.di.ArticlesFeatureComponent
import com.finance.articles.presentation.di.ArticlesFeatureComponentProvider
import com.finance.brief.presentation.di.BriefFeatureComponent
import com.finance.brief.presentation.di.BriefFeatureComponentProvider
import com.finance.common.database.workers.SyncWorker
import com.finance.di.app.AppComponent
import com.finance.di.app.DaggerAppComponent
import com.finance.income.presentation.di.IncomeFeatureComponent
import com.finance.income.presentation.di.IncomeFeatureComponentProvider
import com.finance.outcome.presentation.di.OutcomeFeatureComponent
import com.finance.outcome.presentation.di.OutcomeFeatureComponentProvider
import com.finance.settings.presentation.di.SettingsFeatureComponent
import com.finance.settings.presentation.di.SettingsFeatureComponentProvider


class FinanceApp : Application(), IncomeFeatureComponentProvider, BriefFeatureComponentProvider,
    ArticlesFeatureComponentProvider, SettingsFeatureComponentProvider,
    OutcomeFeatureComponentProvider, Configuration.Provider {


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
        
        // Запускаем периодическую синхронизацию
        SyncWorker.schedulePeriodicSync(this)
        
        // Добавляем минимальные демо-данные для тестирования офлайна
        appComponent.demoDataManager().initializeDemoDataIfNeeded()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(appComponent.daggerWorkerFactory())
            .build()

    override fun provideBriefFeatureComponent(): BriefFeatureComponent =
        appComponent.briefComponentFactory.create()

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