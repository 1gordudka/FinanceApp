package com.finance.income.presentation.screens.history.state_hoisting

import com.finance.domain.transaction.Transaction
import com.finance.income.domain.models.IncomeTransaction


sealed class IncomeHistoryScreenState {
    data class Content(
        val startDate: String,
        val endDate: String,
        val amount: String,
        val currency: String,
        val allTransactions: List<Transaction>,
        val isDatePicker: Boolean = false,
    ) : IncomeHistoryScreenState()
    object Empty : IncomeHistoryScreenState()
    object Error : IncomeHistoryScreenState()
    object Loading : IncomeHistoryScreenState()
} 