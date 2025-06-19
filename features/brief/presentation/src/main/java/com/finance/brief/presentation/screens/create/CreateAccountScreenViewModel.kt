package com.finance.brief.presentation.screens.create

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.finance.brief.domain.models.CreateAccountRequest
import com.finance.brief.domain.results.ObtainAccountResult
import com.finance.brief.domain.results.ObtainCreateAccountResult
import com.finance.brief.domain.use_cases.CreateAccountRequestUseCase
import com.finance.brief.domain.use_cases.GetAccountUseCase
import com.finance.brief.presentation.screens.create.state_hoisting.CreateAccountScreenAction
import com.finance.brief.presentation.screens.create.state_hoisting.CreateAccountScreenEffect
import com.finance.brief.presentation.screens.create.state_hoisting.CreateAccountScreenState
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenAction
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenEffect
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenState
import com.finance.common.ui.state_hoisting.StatefulViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CreateAccountScreenViewModel(
    private val createAccountRequestUseCase: CreateAccountRequestUseCase
) :
    StatefulViewModel<CreateAccountScreenState, CreateAccountScreenEffect, CreateAccountScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, CreateAccountScreenState.Content(
            "", "", ""
        )
    )

    var name = mutableStateOf("")
    var currency = mutableStateOf("")
    var amount = mutableStateOf("")


    override fun onAction(action: CreateAccountScreenAction) {
        when (action) {
            is CreateAccountScreenAction.ChangeAmount -> changeAmount(action.amount)
            is CreateAccountScreenAction.ChangeCurrency -> changeCurrency(action.currency)
            is CreateAccountScreenAction.ChangeName -> changeName(action.name)
            CreateAccountScreenAction.OnBackButton -> {
                viewModelScope.launch {
                    updateEffect(CreateAccountScreenEffect.NavigateBack)
                }
            }

            CreateAccountScreenAction.OnCreateButton -> {
                createAccount(
                    CreateAccountRequest(
                        name.value, amount.value, currency.value
                    )
                )
            }
        }
    }

    private fun createAccount(createAccountRequest: CreateAccountRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(CreateAccountScreenState.Loading)
            val result = createAccountRequestUseCase.invoke(createAccountRequest)
            when (result) {
                ObtainCreateAccountResult.Error -> {
                    updateState(CreateAccountScreenState.Error)
                }

                ObtainCreateAccountResult.Success -> {
                    updateEffect(CreateAccountScreenEffect.NavigateBack)
                }
            }
        }
    }

    private fun changeAmount(value: String) {
        viewModelScope.launch {
            amount.value = value
            updateState(
                CreateAccountScreenState.Content(
                    name = name.value,
                    currency = currency.value,
                    amount = amount.value
                )
            )
        }
    }

    private fun changeCurrency(value: String) {
        viewModelScope.launch {
            currency.value = value
            updateState(
                CreateAccountScreenState.Content(
                    name = name.value,
                    currency = currency.value,
                    amount = amount.value
                )
            )
        }
    }

    private fun changeName(value: String) {
        viewModelScope.launch {
            name.value = value
            updateState(
                CreateAccountScreenState.Content(
                    name = name.value,
                    currency = currency.value,
                    amount = amount.value
                )
            )
        }
    }
}
