package com.finance.income.presentation.screens.main.state_hoisting

import com.finance.income.domain.models.IncomeTransaction

sealed class IncomeMainScreenAction {

    data object OnHistoryClicked : IncomeMainScreenAction()

    data object OnAddIncomeClicked : IncomeMainScreenAction()

    data object OnScreenEntered : IncomeMainScreenAction()
    
    data class OnTransactionClicked(val transaction: IncomeTransaction) : IncomeMainScreenAction()
}