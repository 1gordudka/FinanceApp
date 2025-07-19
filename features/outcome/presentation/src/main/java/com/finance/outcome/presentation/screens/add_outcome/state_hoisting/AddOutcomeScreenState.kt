package com.finance.outcome.presentation.screens.add_outcome.state_hoisting

sealed class AddOutcomeScreenState {
    
    data class Content(
        val amount: String,
        val categoryId: String,
        val comment: String,
        val date: String,
        val accountId: String
    ) : AddOutcomeScreenState()
    
    data object Loading : AddOutcomeScreenState()
    data object Error : AddOutcomeScreenState()
} 