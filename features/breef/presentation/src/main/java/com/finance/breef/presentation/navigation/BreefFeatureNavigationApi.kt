package com.finance.breef.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel
import com.finance.breef.presentation.di.BreefFeatureComponentProvider
import com.finance.breef.presentation.screens.main.BreefMainScreen

class BreefFeatureNavigationApi : FeatureNavigationApi {

    override val navigationRoute: String
        get() = BreefFeatureScreens.navigationRoute

    override val startDestinationRoute: String
        get() = BreefFeatureScreens.startScreenDestination

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

            val breefFeatureComponent =
                (context as BreefFeatureComponentProvider).provideBreefFeatureComponent()

            composable(
                route = BreefFeatureScreens.MainBreefScreen.route
            ) {
                val breefScreenComponent =
                    breefFeatureComponent.breefMainScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    breefScreenComponent.breefMainScreenViewModel
                }

                BreefMainScreen(navController, viewModel)
            }
        }
    }
}
