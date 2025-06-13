package com.finance.articles.presentation.di

import com.finance.articles.presentation.screens.main.di.ArticlesScreenComponent
import dagger.Subcomponent

@ArticlesFeatureComponentScope
@Subcomponent(
    modules = [ArticlesFeatureModule::class]
)
interface ArticlesFeatureComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArticlesFeatureComponent
    }

    val articlesMainScreenComponentFactory: ArticlesScreenComponent.Factory
}
