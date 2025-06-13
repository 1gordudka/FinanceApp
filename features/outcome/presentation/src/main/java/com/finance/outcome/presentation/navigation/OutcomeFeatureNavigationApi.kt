package com.finance.outcome.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel
import com.finance.outcome.presentation.di.OutcomeFeatureComponentProvider
import com.finance.outcome.presentation.screens.main.OutcomeMainScreen


class OutcomeFeatureNavigationApi : FeatureNavigationApi {

    override val navigationRoute: String
        get() = OutcomeFeatureScreens.navigationRoute

    override val startDestinationRoute: String
        get() = OutcomeFeatureScreens.startScreenDestination

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

            val outcomeFeatureComponent =
                (context as OutcomeFeatureComponentProvider).provideOutcomeFeatureComponent()

            composable(
                route = OutcomeFeatureScreens.MainOutcomeScreen.route
            ) {
                val outcomeScreenComponent =
                    outcomeFeatureComponent.outcomeMainScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    outcomeScreenComponent.outcomeMainScreenViewModel
                }

                OutcomeMainScreen(navController, viewModel)
            }
        }
    }
}
