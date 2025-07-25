package com.finance.settings.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.daggerViewModel
import com.finance.settings.presentation.di.SettingsFeatureComponentProvider
import com.finance.settings.presentation.screens.appinfo.AppInfoScreen
import com.finance.settings.presentation.screens.color.PrimaryColorScreen
import com.finance.settings.presentation.screens.haptics.HapticsScreen
import com.finance.settings.presentation.screens.language.LanguageScreen
import com.finance.settings.presentation.screens.main.SettingsMainScreen
import com.finance.settings.presentation.screens.pincode.PinCodeSetupScreen
import com.finance.settings.presentation.screens.sync.SyncFrequencyScreen

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

            composable(SettingsFeatureScreens.PrimaryColorScreen.route) {
                PrimaryColorScreen(
                    navController = navController,
                    settingsUseCases = settingsFeatureComponent.settingsUseCases
                )
            }

            composable(SettingsFeatureScreens.HapticsScreen.route) {
                HapticsScreen(
                    navController = navController,
                    settingsUseCases = settingsFeatureComponent.settingsUseCases
                )
            }

            composable(SettingsFeatureScreens.PinCodeSetupScreen.route) {
                PinCodeSetupScreen(
                    navController = navController,
                    settingsUseCases = settingsFeatureComponent.settingsUseCases
                )
            }

            composable(SettingsFeatureScreens.SyncFrequencyScreen.route) {
                SyncFrequencyScreen(
                    navController = navController,
                    settingsUseCases = settingsFeatureComponent.settingsUseCases,
                    syncFrequencyManager = settingsFeatureComponent.syncFrequencyManager
                )
            }

            composable(SettingsFeatureScreens.LanguageScreen.route) {
                LanguageScreen(
                    navController = navController,
                    settingsUseCases = settingsFeatureComponent.settingsUseCases
                )
            }

            composable(SettingsFeatureScreens.AppInfoScreen.route) {
                AppInfoScreen(navController = navController)
            }
        }
    }
}
