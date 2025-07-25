package com.finance.settings.presentation.navigation

sealed class SettingsFeatureScreens(val route: String) {

    data object MainSettingsScreen : SettingsFeatureScreens("settings_main_screen")
    data object PrimaryColorScreen : SettingsFeatureScreens("primary_color_screen")
    data object HapticsScreen : SettingsFeatureScreens("haptics_screen")
    data object PinCodeSetupScreen : SettingsFeatureScreens("pin_code_setup_screen")
    data object PinCodeVerifyScreen : SettingsFeatureScreens("pin_code_verify_screen")
    data object SyncFrequencyScreen : SettingsFeatureScreens("sync_frequency_screen")
    data object LanguageScreen : SettingsFeatureScreens("language_screen")
    data object AppInfoScreen : SettingsFeatureScreens("app_info_screen")

    companion object {
        const val navigationRoute = "settings_feature_navigation_route"
        val startScreenDestination = MainSettingsScreen.route
    }
}
