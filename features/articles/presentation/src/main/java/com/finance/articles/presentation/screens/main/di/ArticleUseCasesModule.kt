package com.finance.articles.presentation.screens.main.di

import com.finance.articles.domain.models.repository.ArticleFeatureRepository
import com.finance.articles.domain.models.use_cases.GetCategoriesUseCase
import dagger.Module
import dagger.Provides

@Module
class ArticleUseCasesModule {

    @ArticlesScreenComponentScope
    @Provides
    fun provideGetCategoriesUseCase(
        articleFeatureRepository: ArticleFeatureRepository
    ): GetCategoriesUseCase = GetCategoriesUseCase(articleFeatureRepository)
}