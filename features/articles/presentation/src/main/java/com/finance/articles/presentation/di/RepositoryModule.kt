package com.finance.articles.presentation.di

import com.finance.articles.data.remote.network.CategoryService
import com.finance.articles.data.remote.repository.RemoteCategoryRepository
import com.finance.articles.data.remote.repository.RemoteCategoryRepositoryImpl
import com.finance.articles.data.repository.ArticleFeatureRepositoryImpl
import com.finance.articles.domain.models.repository.ArticleFeatureRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @ArticlesFeatureComponentScope
    @Provides
    fun provideRemoteCategoriesRepository(
        categoryService: CategoryService
    ): RemoteCategoryRepository =
        RemoteCategoryRepositoryImpl(categoryService)

    @ArticlesFeatureComponentScope
    @Provides
    fun provideCategoryFeatureRepository(
        remoteCategoryRepository: RemoteCategoryRepository
    ): ArticleFeatureRepository = ArticleFeatureRepositoryImpl(remoteCategoryRepository)
}