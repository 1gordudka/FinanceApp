package com.finance.income.presentation.screens.history.state_hoisting

import com.finance.domain.transaction.Transaction

sealed class IncomeHistoryScreenAction {
    object OnBackClicked : IncomeHistoryScreenAction()
    object OnCalendarClicked : IncomeHistoryScreenAction()

    data class GetData(val startDate: String, val endDate: String,) : IncomeHistoryScreenAction()
    data class OnTransactionClicked(val transaction: Transaction) : IncomeHistoryScreenAction()
} 