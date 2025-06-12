package com.finance.articles.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel
import com.finance.articles.presentation.di.ArticlesFeatureComponentProvider
import com.finance.articles.presentation.screens.main.ArticlesMainScreen

class ArticlesFeatureNavigationApi : FeatureNavigationApi {

    override val navigationRoute: String
        get() = ArticlesFeatureScreens.navigationRoute

    override val startDestinationRoute: String
        get() = ArticlesFeatureScreens.startScreenDestination

    override fun registerFeatureNavigationGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation(
            startDestinationRoute,
            navigationRoute
        ) {
            val context = navController.context.applicationContext

            val articlesFeatureComponent =
                (context as ArticlesFeatureComponentProvider).provideArticlesFeatureComponent()

            composable(
                route = ArticlesFeatureScreens.MainArticlesScreen.route
            ) {
                val articlesScreenComponent =
                    articlesFeatureComponent.articlesMainScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    articlesScreenComponent.articlesMainScreenViewModel
                }

                ArticlesMainScreen(navController, viewModel)
            }
        }
    }
}
