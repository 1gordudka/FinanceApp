package com.finance.articles.presentation.screens.main.di

import com.finance.articles.domain.models.use_cases.GetCategoriesUseCase
import com.finance.articles.presentation.screens.main.ArticlesMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module(
    includes = [ArticleUseCasesModule::class]
)
class ArticlesScreenModule {

    @ArticlesScreenComponentScope
    @Provides
    fun provideArticlesMainScreenViewModel(
        getCategoriesUseCase: GetCategoriesUseCase
    ): ArticlesMainScreenViewModel =
        ArticlesMainScreenViewModel(getCategoriesUseCase)
}
