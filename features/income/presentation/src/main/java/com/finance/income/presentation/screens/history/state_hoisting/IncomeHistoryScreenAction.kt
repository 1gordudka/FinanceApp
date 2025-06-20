package com.finance.income.presentation.screens.history.state_hoisting

sealed class IncomeHistoryScreenAction {
    object OnBackClicked : IncomeHistoryScreenAction()
    object OnCalendarClicked : IncomeHistoryScreenAction()

    data class GetData(val startDate: String, val endDate: String,) : IncomeHistoryScreenAction()
} 