package com.finance.income.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.features.income.data.remote.mappers.incomeCategoryToUIMapper
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.income.domain.results.ObtainIncomeData
import com.finance.income.domain.use_cases.GetTodayIncomeUseCase
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenAction
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenEffect
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class IncomeMainScreenViewModel(
    private val getTodayIncomeUseCase: GetTodayIncomeUseCase
) :
    StatefulViewModel<IncomeMainScreenState, IncomeMainScreenEffect, IncomeMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, IncomeMainScreenState.Loading
    )

    init {
        onAction(IncomeMainScreenAction.OnScreenEntered)
    }

    override fun onAction(action: IncomeMainScreenAction) {
        when (action) {
            IncomeMainScreenAction.OnHistoryClicked -> {
                viewModelScope.launch {
                    updateEffect(
                        IncomeMainScreenEffect.NavigateToHistoryScreen
                    )
                }
            }

            IncomeMainScreenAction.OnAddIncomeClicked -> {
                viewModelScope.launch {
                    updateEffect(
                        IncomeMainScreenEffect.NavigateToAddIncomeScreen
                    )
                }
            }

            IncomeMainScreenAction.OnScreenEntered -> {
                loadIncome()
            }
            
            is IncomeMainScreenAction.OnTransactionClicked -> {
                viewModelScope.launch {
                    updateEffect(
                        IncomeMainScreenEffect.NavigateToEditIncomeScreen(action.transaction.id)
                    )
                }
            }
        }
    }

    private fun loadIncome() {

        viewModelScope.launch(Dispatchers.IO) {
            updateState(IncomeMainScreenState.Loading)
            val result = getTodayIncomeUseCase.invoke(getTodayDate())
            when (result) {
                ObtainIncomeData.Error -> updateState(IncomeMainScreenState.Error)
                is ObtainIncomeData.Success -> {
                    if (result.transactions.isNotEmpty()) {
                        updateState(
                            IncomeMainScreenState.Content(
                                allIncome = result.allIncome,
                                categories = incomeCategoryToUIMapper(result.transactions)
                            )
                        )
                    } else {
                        updateState(IncomeMainScreenState.Empty)
                    }
                }
            }
        }
    }
}


fun getTodayDate(): String {
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return today.format(formatter)
}