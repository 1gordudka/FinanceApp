package com.finance.brief.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finance.brief.presentation.di.BriefFeatureComponentProvider
import com.finance.brief.presentation.screens.create.CreateAccountScreen
import com.finance.brief.presentation.screens.main.BriefMainScreen
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel

class BriefFeatureNavigationApi : FeatureNavigationApi {

    override val navigationRoute: String
        get() = BriefFeatureScreens.navigationRoute

    override val startDestinationRoute: String
        get() = BriefFeatureScreens.startScreenDestination

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

            val briefFeatureComponent =
                (context as BriefFeatureComponentProvider).provideBriefFeatureComponent()

            composable(
                route = BriefFeatureScreens.MainBriefScreen.route
            ) {
                val briefScreenComponent =
                    briefFeatureComponent.briefMainScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    briefScreenComponent.briefMainScreenViewModel
                }

                BriefMainScreen(navController, viewModel)
            }

            composable(
                route = BriefFeatureScreens.CreateAccountScreen.route
            ) {
                val createAccountScreenComponent =
                    briefFeatureComponent.createAccountScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    createAccountScreenComponent.createAccountScreenViewModel
                }

                CreateAccountScreen(navController, viewModel)
            }
        }
    }
}
