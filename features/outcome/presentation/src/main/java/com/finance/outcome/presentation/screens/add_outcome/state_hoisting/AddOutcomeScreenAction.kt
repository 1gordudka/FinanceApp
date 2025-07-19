package com.finance.outcome.presentation.screens.add_outcome.state_hoisting

sealed class AddOutcomeScreenAction {
    data object OnBackButton: AddOutcomeScreenAction()
    data object OnCreateButton: AddOutcomeScreenAction()
    data object OnRetryButton: AddOutcomeScreenAction()
    
    data class OnAmountChange(val amount: String): AddOutcomeScreenAction()
    data class OnCategoryIdChange(val categoryId: String): AddOutcomeScreenAction()
    data class OnCommentChange(val comment: String): AddOutcomeScreenAction()
    data class OnDateChange(val date: String): AddOutcomeScreenAction()
    data class OnAccountIdChange(val accountId: String): AddOutcomeScreenAction()
} 