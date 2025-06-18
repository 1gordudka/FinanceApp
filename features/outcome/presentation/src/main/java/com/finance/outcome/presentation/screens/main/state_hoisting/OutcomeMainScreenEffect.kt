package com.finance.outcome.presentation.screens.main.state_hoisting

sealed class OutcomeMainScreenEffect {

    data object NavigateToHistoryScreen : OutcomeMainScreenEffect()
}