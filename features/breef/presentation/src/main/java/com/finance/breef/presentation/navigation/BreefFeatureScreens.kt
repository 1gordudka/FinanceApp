package com.finance.breef.presentation.navigation

sealed class BreefFeatureScreens(val route: String) {

    data object MainBreefScreen : BreefFeatureScreens("breef_main_screen")

    companion object {
        const val navigationRoute = "breef_feature_navigation_route"
        val startScreenDestination = MainBreefScreen.route
    }
}
