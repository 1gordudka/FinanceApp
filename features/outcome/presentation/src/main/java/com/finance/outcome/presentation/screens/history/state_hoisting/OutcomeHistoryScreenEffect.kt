package com.finance.outcome.presentation.screens.history.state_hoisting

sealed class OutcomeHistoryScreenEffect {

    data object NavigateBack : OutcomeHistoryScreenEffect()
}