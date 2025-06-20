package com.finance.income.presentation.screens.main.state_hoisting

sealed class IncomeMainScreenAction {

    data object OnHistoryClicked : IncomeMainScreenAction()

    data object OnScreenEntered : IncomeMainScreenAction()
}