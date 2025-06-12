package com.finance.articles.presentation.screens.main.di

import com.finance.articles.presentation.screens.main.ArticlesMainScreenViewModel
import dagger.Subcomponent

@ArticlesScreenComponentScope
@Subcomponent(
    modules = [ArticlesScreenModule::class]
)
interface ArticlesScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArticlesScreenComponent
    }

    val articlesMainScreenViewModel: ArticlesMainScreenViewModel
}
