package com.finance.outcome.presentation.di

import dagger.Module

@Module(
    includes = [NetworkModule::class, RepositoryModule::class]
)
class OutcomeFeatureModule

