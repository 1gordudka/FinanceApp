package com.finance.settings.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel
import com.finance.settings.presentation.di.SettingsFeatureComponentProvider
import com.finance.settings.presentation.screens.main.SettingsMainScreen

class SettingsFeatureNavigationApi : FeatureNavigationApi {

    override val navigationRoute: String
        get() = SettingsFeatureScreens.navigationRoute

    override val startDestinationRoute: String
        get() = SettingsFeatureScreens.startScreenDestination

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

            val settingsFeatureComponent =
                (context as SettingsFeatureComponentProvider).provideSettingsFeatureComponent()

            composable(
                route = SettingsFeatureScreens.MainSettingsScreen.route
            ) {
                val settingsScreenComponent =
                    settingsFeatureComponent.settingsMainScreenComponentFactory.create()

                val viewModel = daggerViewModel {
                    settingsScreenComponent.settingsMainScreenViewModel
                }

                SettingsMainScreen(navController, viewModel)
            }
        }
    }
}
