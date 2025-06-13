package com.finance.articles.presentation.screens.main.di

import com.finance.articles.presentation.screens.main.ArticlesMainScreenViewModel
import dagger.Module
import dagger.Provides

@Module
class ArticlesScreenModule {

    @ArticlesScreenComponentScope
    @Provides
    fun provideArticlesMainScreenViewModel(): ArticlesMainScreenViewModel =
        ArticlesMainScreenViewModel()
}
