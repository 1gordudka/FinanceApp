package com.finance.brief.presentation.di

import dagger.Module

@Module(
    includes = [NetworkModule::class, RepositoryModule::class]
)
class BriefFeatureModule
