package com.finance.outcome.presentation.navigation

sealed class OutcomeFeatureScreens(val route: String) {

    data object MainOutcomeScreen : OutcomeFeatureScreens("outcome_main_screen")

    companion object {
        const val navigationRoute = "outcome_feature_navigation_route"
        val startScreenDestination = MainOutcomeScreen.route
    }
}
