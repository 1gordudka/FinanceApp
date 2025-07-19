package com.finance.income.presentation.screens.history.state_hoisting

import com.finance.domain.transaction.Transaction

sealed class IncomeHistoryScreenEffect {
    object NavigateBack : IncomeHistoryScreenEffect()
    data class NavigateToEditIncome(val transaction: Transaction) : IncomeHistoryScreenEffect()
} 