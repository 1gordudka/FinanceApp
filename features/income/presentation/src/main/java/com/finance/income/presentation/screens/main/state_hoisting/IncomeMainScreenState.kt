package com.finance.income.presentation.screens.main.state_hoisting

import com.finance.income.domain.models.AllIncome
import com.finance.income.domain.models.IncomeCategory

sealed class IncomeMainScreenState {

    data class Content(
        val allIncome: AllIncome,
        val categories: List<IncomeCategory>
    ) : IncomeMainScreenState()

    data object Loading : IncomeMainScreenState()

    data object Empty: IncomeMainScreenState()

    data object Error: IncomeMainScreenState()
}