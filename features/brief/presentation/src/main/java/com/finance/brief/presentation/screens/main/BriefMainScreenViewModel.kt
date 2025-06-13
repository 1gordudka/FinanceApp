package com.finance.brief.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.brief.data.mock.balance
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenAction
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenEffect
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenState
import com.finance.common.ui.state_hoisting.StatefulViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

class BriefMainScreenViewModel() :
    StatefulViewModel<BriefMainScreenState, BriefMainScreenEffect, BriefMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, BriefMainScreenState.Content(
            balance = balance
        )
    )

    override fun onAction(action: BriefMainScreenAction) {

    }
}

