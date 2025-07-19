package com.finance.income.presentation.screens.add_income.state_hoisting

sealed class AddIncomeScreenState {
    data object Error: AddIncomeScreenState()
    data object Loading: AddIncomeScreenState()
    
    data class Content(
        val amount: String,
        val categoryId: String,
        val comment: String,
        val date: String,
        val accountId: String,
    ): AddIncomeScreenState()
} 