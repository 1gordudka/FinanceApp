package com.finance.outcome.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.outcome.data.mock.allCategories
import com.finance.outcome.data.mock.allOutcome
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenAction
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenEffect
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

class OutcomeMainScreenViewModel() :
    StatefulViewModel<OutcomeMainScreenState, OutcomeMainScreenEffect, OutcomeMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, OutcomeMainScreenState.Content(

            categories = allCategories,
            allOutcome = allOutcome
        )
    )

    override fun onAction(action: OutcomeMainScreenAction) {
        // handle outcome actions here
    }
}
