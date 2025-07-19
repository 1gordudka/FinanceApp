package com.finance.outcome.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel
import com.finance.outcome.presentation.di.OutcomeFeatureComponentProvider
import com.finance.outcome.presentation.screens.add_outcome.AddOutcomeScreen
import com.finance.outcome.presentation.screens.add_outcome.di.AddOutcomeScreenModule
import com.finance.outcome.presentation.screens.add_outcome.models.OutcomeScreenMode
import com.finance.outcome.presentation.screens.history.OutcomeHistoryScreen
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

            composable(
                route = OutcomeFeatureScreens.HistoryOutcomeScreen.route
            ) {

                val outcomeHistoryScreenComponent =
                    outcomeFeatureComponent.outcomeHistoryScreenComponentFactory.create()
                val viewModel = daggerViewModel {
                    outcomeHistoryScreenComponent.outcomeHistoryScreenViewModel
                }

                OutcomeHistoryScreen(navController, viewModel)
            }

            composable(
                route = OutcomeFeatureScreens.AddOutcomeScreen.route
            ) {
                val addOutcomeScreenComponent =
                    outcomeFeatureComponent.addOutcomeScreenComponentFactory.create(
                        AddOutcomeScreenModule(OutcomeScreenMode.Create)
                    )

                val viewModel = daggerViewModel {
                    addOutcomeScreenComponent.addOutcomeScreenViewModel
                }

                AddOutcomeScreen(
                    navController, viewModel, addOutcomeScreenComponent.outcomeScreenMode
                )

            }

            composable(
                route = OutcomeFeatureScreens.EditOutcomeScreen.route,
                arguments = listOf(navArgument("transactionId") { type = NavType.IntType })
            ) { backStackEntry ->
                val transactionId = backStackEntry.arguments?.getInt("transactionId") ?: 0

                val addOutcomeScreenComponent =
                    outcomeFeatureComponent.addOutcomeScreenComponentFactory.create(
                        AddOutcomeScreenModule(OutcomeScreenMode.EditById(transactionId))
                    )

                val viewModel = daggerViewModel {
                    addOutcomeScreenComponent.addOutcomeScreenViewModel
                }

                AddOutcomeScreen(
                    navController, viewModel, addOutcomeScreenComponent.outcomeScreenMode
                )

            }


        }
    }
}
