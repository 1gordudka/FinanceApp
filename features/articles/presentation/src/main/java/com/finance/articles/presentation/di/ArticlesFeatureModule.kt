package com.finance.articles.presentation.di

import dagger.Module

@Module(includes = [NetworkModule::class, RepositoryModule::class])
class ArticlesFeatureModule
