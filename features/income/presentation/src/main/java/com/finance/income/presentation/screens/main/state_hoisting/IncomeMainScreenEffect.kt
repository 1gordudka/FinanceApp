package com.finance.income.presentation.screens.main.state_hoisting

sealed class IncomeMainScreenEffect {

    data object NavigateToHistoryScreen : IncomeMainScreenEffect()
    
    data object NavigateToAddIncomeScreen : IncomeMainScreenEffect()
    
    data class NavigateToEditIncomeScreen(val transactionId: Int) : IncomeMainScreenEffect()
}