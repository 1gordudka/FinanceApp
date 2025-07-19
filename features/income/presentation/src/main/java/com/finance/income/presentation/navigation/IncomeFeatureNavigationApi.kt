package com.finance.income.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel
import com.finance.income.presentation.di.IncomeFeatureComponentProvider
import com.finance.income.presentation.screens.add_income.AddIncomeScreen
import com.finance.income.presentation.screens.add_income.di.AddIncomeScreenModule
import com.finance.income.presentation.screens.add_income.models.IncomeScreenMode
import com.finance.income.presentation.screens.history.IncomeHistoryScreen
import com.finance.income.presentation.screens.main.IncomeMainScreen

class IncomeFeatureNavigationApi : FeatureNavigationApi {

    override val navigationRoute: String
        get() = IncomeFeatureScreens.navigationRoute

    override val startDestinationRoute: String
        get() = IncomeFeatureScreens.startScreenDestination

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

            val incomeFeatureComponent =
                (context as IncomeFeatureComponentProvider).provideIncomeFeatureComponent()

            composable(
                route = IncomeFeatureScreens.MainIncomeScreen.route
            ) {

                val incomeScreenComponent =
                    incomeFeatureComponent.incomeMainScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    incomeScreenComponent.incomeMainScreenViewModel
                }

                IncomeMainScreen(
                    navController, viewModel
                )

            }

            composable(
                route = IncomeFeatureScreens.HistoryIncomeScreen.route
            ) {

                val incomeScreenComponent =
                    incomeFeatureComponent.incomeHistoryScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    incomeScreenComponent.incomeHistoryScreenViewModel
                }

                IncomeHistoryScreen(
                    navController, viewModel
                )

            }

            composable(
                route = IncomeFeatureScreens.AddIncomeScreen.route
            ) {

                val addIncomeScreenComponent =
                    incomeFeatureComponent.addIncomeScreenComponentFactory.create(
                        AddIncomeScreenModule(IncomeScreenMode.Create)
                    )

                val viewModel = daggerViewModel {
                    addIncomeScreenComponent.addIncomeScreenViewModel
                }

                AddIncomeScreen(
                    navController, viewModel, addIncomeScreenComponent.incomeScreenMode
                )

            }

            composable(
                route = IncomeFeatureScreens.EditIncomeScreen.route,
                arguments = listOf(navArgument("transactionId") { type = NavType.IntType })
            ) { backStackEntry ->
                val transactionId = backStackEntry.arguments?.getInt("transactionId") ?: 0

                val addIncomeScreenComponent =
                    incomeFeatureComponent.addIncomeScreenComponentFactory.create(
                        AddIncomeScreenModule(IncomeScreenMode.EditById(transactionId))
                    )

                val viewModel = daggerViewModel {
                    addIncomeScreenComponent.addIncomeScreenViewModel
                }

                AddIncomeScreen(
                    navController, viewModel, addIncomeScreenComponent.incomeScreenMode
                )

            }
        }
    }
}