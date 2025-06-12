package com.finance.breef.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.breef.data.mock.balance
import com.finance.breef.presentation.screens.main.state_hoisting.BreefMainScreenAction
import com.finance.breef.presentation.screens.main.state_hoisting.BreefMainScreenEffect
import com.finance.breef.presentation.screens.main.state_hoisting.BreefMainScreenState
import com.finance.common.ui.state_hoisting.StatefulViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

class BreefMainScreenViewModel() :
    StatefulViewModel<BreefMainScreenState, BreefMainScreenEffect, BreefMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, BreefMainScreenState.Content(
            balance = balance
        )
    )

    override fun onAction(action: BreefMainScreenAction) {
        // handle breef actions here
    }
}

