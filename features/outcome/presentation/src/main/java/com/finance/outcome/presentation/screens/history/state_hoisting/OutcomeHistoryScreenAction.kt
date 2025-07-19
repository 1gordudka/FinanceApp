package com.finance.outcome.presentation.screens.history.state_hoisting

import com.finance.domain.transaction.Transaction

sealed class OutcomeHistoryScreenAction {

    data object OnBackClicked : OutcomeHistoryScreenAction()

    data object OnCalendarClicked : OutcomeHistoryScreenAction()

    data class GetData(val startDate: String, val endDate: String,) : OutcomeHistoryScreenAction()
    
    data class OnTransactionClicked(val transaction: Transaction) : OutcomeHistoryScreenAction()
}