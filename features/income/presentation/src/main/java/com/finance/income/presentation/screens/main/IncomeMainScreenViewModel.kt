package com.finance.income.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.features.income.data.mock.allCategories
import com.features.income.data.mock.allIncome
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenAction
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenEffect
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

class IncomeMainScreenViewModel() :
    StatefulViewModel<IncomeMainScreenState, IncomeMainScreenEffect, IncomeMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, IncomeMainScreenState.Content(
            allIncome = allIncome,
            categories = allCategories
        )
    )

    override fun onAction(action: IncomeMainScreenAction) {

    }
}