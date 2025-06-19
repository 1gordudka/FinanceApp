package com.finance.brief.presentation.navigation

sealed class BriefFeatureScreens(val route: String) {

    data object MainBriefScreen : BriefFeatureScreens("brief_main_screen")
    data object CreateAccountScreen: BriefFeatureScreens("brief_create_screen")

    companion object {
        const val navigationRoute = "brief_feature_navigation_route"
        val startScreenDestination = MainBriefScreen.route
    }
}
