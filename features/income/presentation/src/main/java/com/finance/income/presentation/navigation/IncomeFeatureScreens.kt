package com.finance.income.presentation.navigation

sealed class IncomeFeatureScreens (
    val route: String
){

    data object MainIncomeScreen : IncomeFeatureScreens("income_main_screen")
    data object HistoryIncomeScreen : IncomeFeatureScreens("income_history_screen")


    companion object{

        const val navigationRoute = "income_feature_navigation_route"
        val startScreenDestination = MainIncomeScreen.route
    }
}