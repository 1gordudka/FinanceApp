package com.finance.outcome.presentation.navigation

sealed class OutcomeFeatureScreens(val route: String) {

    data object MainOutcomeScreen : OutcomeFeatureScreens("outcome_main_screen")
    data object HistoryOutcomeScreen : OutcomeFeatureScreens("outcome_history_screen")
    data object AddOutcomeScreen : OutcomeFeatureScreens("add_outcome_screen")
    data object EditOutcomeScreen : OutcomeFeatureScreens("edit_outcome_screen/{transactionId}")

    companion object {
        const val navigationRoute = "outcome_feature_navigation_route"
        val startScreenDestination = MainOutcomeScreen.route
        
        fun createEditOutcomeRoute(transactionId: Int): String {
            return "edit_outcome_screen/$transactionId"
        }
    }
}
