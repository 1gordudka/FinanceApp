package com.finance.outcome.presentation.screens.main.state_hoisting

import com.finance.outcome.domain.models.OutcomeCategory

sealed class OutcomeMainScreenAction {

    data object OnHistoryClicked : OutcomeMainScreenAction()

    data object OnAddOutcomeClicked : OutcomeMainScreenAction()

    data object OnScreenEntered : OutcomeMainScreenAction()
    
    data class OnTransactionClicked(val transaction: OutcomeCategory) : OutcomeMainScreenAction()
}