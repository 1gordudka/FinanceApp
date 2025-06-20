package com.finance.outcome.presentation.screens.history.state_hoisting

sealed class OutcomeHistoryScreenAction {

    data object OnBackClicked : OutcomeHistoryScreenAction()

    data object OnCalendarClicked : OutcomeHistoryScreenAction()

    data class GetData(val startDate: String, val endDate: String,) : OutcomeHistoryScreenAction()
}