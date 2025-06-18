package com.finance.outcome.presentation.screens.history

import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.outcome.data.mock.allCategories
import com.finance.outcome.data.mock.allOutcome
import com.finance.outcome.data.mock.transactionsMockData
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenAction
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenEffect
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenState
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenAction
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenEffect
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OutcomeHistoryScreenViewModel() :
    StatefulViewModel<OutcomeHistoryScreenState, OutcomeHistoryScreenEffect, OutcomeHistoryScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, OutcomeHistoryScreenState.Content(
            allTransactions = transactionsMockData,
            startDate = "Февраль 2025",
            endDate = "Март 2025",
            amount = "123 943",
            currency = "₽"
        )
    )

    override fun onAction(action: OutcomeHistoryScreenAction) {
        when (action) {
            OutcomeHistoryScreenAction.OnBackClicked -> {
                viewModelScope.launch {
                    updateEffect(OutcomeHistoryScreenEffect.NavigateBack)
                }
            }

            OutcomeHistoryScreenAction.OnCalendarClicked -> {

            }
        }
    }
}
