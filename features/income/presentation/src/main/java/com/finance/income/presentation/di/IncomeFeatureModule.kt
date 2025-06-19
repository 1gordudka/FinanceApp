package com.finance.income.presentation.di

import dagger.Module
import com.finance.income.presentation.screens.history.di.IncomeHistoryScreenModule

@Module(
    includes = [NetworkModule::class, RepositoryModule::class]
)
class IncomeFeatureModule {
}