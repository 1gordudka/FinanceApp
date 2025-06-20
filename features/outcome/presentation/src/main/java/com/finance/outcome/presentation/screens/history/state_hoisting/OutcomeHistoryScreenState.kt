package com.finance.outcome.presentation.screens.history.state_hoisting

import com.finance.domain.transaction.Transaction
import com.finance.outcome.data.remote.models.TransactionResponse

sealed class OutcomeHistoryScreenState {

    data class Content(
        val allTransactions: List<Transaction>,
        val startDate: String,
        val endDate: String,
        val amount: String,
        val currency: String,
        val isDatePicker: Boolean = false,
    ) : OutcomeHistoryScreenState()

    data object Loading : OutcomeHistoryScreenState()

    data object Empty : OutcomeHistoryScreenState()

    data object Error : OutcomeHistoryScreenState()
}