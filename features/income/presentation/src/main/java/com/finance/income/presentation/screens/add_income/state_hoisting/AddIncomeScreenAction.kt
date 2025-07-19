package com.finance.income.presentation.screens.add_income.state_hoisting

sealed class AddIncomeScreenAction {
    data object OnBackButton: AddIncomeScreenAction()
    data object OnCreateButton: AddIncomeScreenAction()
    data object OnRetryButton: AddIncomeScreenAction()
    
    data class ChangeAmount(val amount: String): AddIncomeScreenAction()
    data class ChangeCategoryId(val categoryId: String): AddIncomeScreenAction()
    data class ChangeComment(val comment: String): AddIncomeScreenAction()
    data class ChangeDate(val date: String): AddIncomeScreenAction()
    data class ChangeAccountId(val accountId: String): AddIncomeScreenAction()
} 