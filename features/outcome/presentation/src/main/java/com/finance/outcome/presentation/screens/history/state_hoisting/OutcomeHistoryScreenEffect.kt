package com.finance.outcome.presentation.screens.history.state_hoisting

import com.finance.domain.transaction.Transaction

sealed class OutcomeHistoryScreenEffect {

    data object NavigateBack : OutcomeHistoryScreenEffect()
    
    data class NavigateToEditOutcome(val transaction: Transaction) : OutcomeHistoryScreenEffect()
}