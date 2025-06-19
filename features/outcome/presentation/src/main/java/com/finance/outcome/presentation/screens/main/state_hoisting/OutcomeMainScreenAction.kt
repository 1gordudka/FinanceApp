package com.finance.outcome.presentation.screens.main.state_hoisting

sealed class OutcomeMainScreenAction {

    data object OnHistoryClicked : OutcomeMainScreenAction()

    data object OnScreenEntered : OutcomeMainScreenAction()
}