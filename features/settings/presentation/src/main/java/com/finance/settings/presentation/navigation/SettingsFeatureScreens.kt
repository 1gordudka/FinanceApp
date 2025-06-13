package com.finance.settings.presentation.navigation

sealed class SettingsFeatureScreens(val route: String) {

    data object MainSettingsScreen : SettingsFeatureScreens("settings_main_screen")

    companion object {
        const val navigationRoute = "settings_feature_navigation_route"
        val startScreenDestination = MainSettingsScreen.route
    }
}
