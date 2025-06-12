package com.finance.articles.presentation.navigation

sealed class ArticlesFeatureScreens(val route: String) {

    data object MainArticlesScreen : ArticlesFeatureScreens("articles_main_screen")

    companion object {
        const val navigationRoute = "articles_feature_navigation_route"
        val startScreenDestination = MainArticlesScreen.route
    }
}
