package com.finance.brief.presentation.navigation

sealed class BriefFeatureScreens(val route: String) {

    data object MainBriefScreen : BriefFeatureScreens("brief_main_screen")

    companion object {
        const val navigationRoute = "brief_feature_navigation_route"
        val startScreenDestination = MainBriefScreen.route
    }
}
