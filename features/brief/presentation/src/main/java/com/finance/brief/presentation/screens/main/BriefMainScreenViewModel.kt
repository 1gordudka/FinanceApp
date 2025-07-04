package com.finance.brief.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.brief.domain.models.Balance
import com.finance.brief.domain.results.ObtainAccountResult
import com.finance.brief.domain.results.ObtainChangeAccountResult
import com.finance.brief.domain.use_cases.ChangeAccountInfoUseCase
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
    private val getAccountUseCase: GetAccountUseCase,
    private val changeAccountInfoUseCase: ChangeAccountInfoUseCase
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

            BriefMainScreenAction.OnEditButton -> {
                viewModelScope.launch {
                    updateState(
                        BriefMainScreenState.Update(
                            balance = (state.value as BriefMainScreenState.Content).balance
                        )
                    )
                }
            }

            BriefMainScreenAction.OnExitEdit -> {
                onAction(BriefMainScreenAction.OnScreenEntered)
            }

            is BriefMainScreenAction.OnUpdateInfo -> {
                changeAccountInfo(action.balance)
            }
        }
    }

    private fun changeAccountInfo(balance: Balance) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(BriefMainScreenState.Loading)
            val result = changeAccountInfoUseCase.invoke(
                balance.name,
                balance.formattedAmount,
                balance.currency
            )
            when (result) {
                ObtainChangeAccountResult.Error -> updateState(BriefMainScreenState.Error)
                is ObtainChangeAccountResult.Success -> {
                    updateState(
                        BriefMainScreenState.Content(
                            balance = result.account
                        )
                    )
                }
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

