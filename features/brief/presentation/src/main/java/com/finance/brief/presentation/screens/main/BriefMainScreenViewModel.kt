package com.finance.brief.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.brief.data.mock.balance
import com.finance.brief.domain.results.ObtainAccountResult
import com.finance.brief.domain.use_cases.GetAccountUseCase
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenAction
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenEffect
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenState
import com.finance.common.ui.state_hoisting.StatefulViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BriefMainScreenViewModel(
    private val getAccountUseCase: GetAccountUseCase
) :
    StatefulViewModel<BriefMainScreenState, BriefMainScreenEffect, BriefMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, BriefMainScreenState.Loading
    )

    init {

        onAction(BriefMainScreenAction.OnScreenEntered)
    }

    override fun onAction(action: BriefMainScreenAction) {
        when (action) {
            BriefMainScreenAction.OnScreenEntered -> {
                loadAccount()
            }
        }
    }

    private fun loadAccount() {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(BriefMainScreenState.Loading)
            val result = getAccountUseCase.invoke()
            when (result) {
                ObtainAccountResult.Error -> updateState(BriefMainScreenState.Error)
                is ObtainAccountResult.Success -> {
                    updateState(
                        BriefMainScreenState.Content(
                            balance = result.account
                        )
                    )
                }
            }
        }
    }
}

