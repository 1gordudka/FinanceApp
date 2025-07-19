package com.finance.outcome.presentation.screens.main.state_hoisting

sealed class OutcomeMainScreenEffect {

    data object NavigateToHistoryScreen : OutcomeMainScreenEffect()
    
    data object NavigateToAddOutcomeScreen : OutcomeMainScreenEffect()
    
    data class NavigateToEditOutcomeScreen(val transactionId: Int) : OutcomeMainScreenEffect()
}