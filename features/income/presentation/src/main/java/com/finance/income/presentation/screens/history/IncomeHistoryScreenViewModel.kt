package com.finance.income.presentation.screens.history

import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.income.domain.results.ObtainIncomeData
import com.finance.income.domain.use_cases.GetIncomeDataUseCase
import com.finance.income.presentation.screens.history.state_hoisting.IncomeHistoryScreenAction
import com.finance.income.presentation.screens.history.state_hoisting.IncomeHistoryScreenEffect
import com.finance.income.presentation.screens.history.state_hoisting.IncomeHistoryScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class IncomeHistoryScreenViewModel(
    private val getIncomeDataUseCase: GetIncomeDataUseCase
) :
    StatefulViewModel<IncomeHistoryScreenState, IncomeHistoryScreenEffect, IncomeHistoryScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, IncomeHistoryScreenState.Loading
    )

    init {
        onAction(
            IncomeHistoryScreenAction.GetData(
                startDate = "2025-06-01",
                endDate = "2025-06-30"
            )
        )
    }

    override fun onAction(action: IncomeHistoryScreenAction) {
        when (action) {
            IncomeHistoryScreenAction.OnBackClicked -> {
                viewModelScope.launch {
                    updateEffect(IncomeHistoryScreenEffect.NavigateBack)
                }
            }

            IncomeHistoryScreenAction.OnCalendarClicked -> {
                viewModelScope.launch {
                    updateState(
                        IncomeHistoryScreenState.Content(
                            startDate = "ГГГГ-ММ-ДД",
                            endDate = "ГГГГ-ММ-ДД",
                            amount = "0.00",
                            currency = "RUB",
                            allTransactions = emptyList(),
                            isDatePicker = true
                        )
                    )
                }
            }

            is IncomeHistoryScreenAction.GetData -> {
                getIncomeData(action.startDate, action.endDate)
            }
        }
    }

    private fun getIncomeData(startDate: String, endDate: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(IncomeHistoryScreenState.Loading)
            val result = getIncomeDataUseCase.invoke(startDate, endDate)
            when (result) {
                ObtainIncomeData.Error -> updateState(IncomeHistoryScreenState.Error)
                is ObtainIncomeData.Success -> {
                    if (result.transactions.isNotEmpty()) {
                        updateState(
                            IncomeHistoryScreenState.Content(
                                startDate = startDate,
                                endDate = endDate,
                                amount = result.allIncome.formattedAmount,
                                currency = result.allIncome.currency,
                                allTransactions = result.transactions,
                                isDatePicker = false
                            )
                        )
                    } else {
                        updateState(
                            IncomeHistoryScreenState.Empty
                        )
                    }
                }
            }
        }
    }
} 