package com.finance.income.presentation.screens.main.state_hoisting

sealed class IncomeMainScreenEffect {

    data object NavigateToHistoryScreen : IncomeMainScreenEffect()
}