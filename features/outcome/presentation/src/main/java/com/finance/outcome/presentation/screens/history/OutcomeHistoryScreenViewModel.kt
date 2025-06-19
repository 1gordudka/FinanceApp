package com.finance.outcome.presentation.screens.history

import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.outcome.data.mock.allCategories
import com.finance.outcome.data.mock.allOutcome
import com.finance.outcome.data.mock.transactionsMockData
import com.finance.outcome.domain.results.ObtainOutcomeData
import com.finance.outcome.domain.use_cases.GetOutcomeDataUseCase
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenAction
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenEffect
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenState
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenAction
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenEffect
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OutcomeHistoryScreenViewModel(
    private val getOutcomeDataUseCase: GetOutcomeDataUseCase
) :
    StatefulViewModel<OutcomeHistoryScreenState, OutcomeHistoryScreenEffect, OutcomeHistoryScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, OutcomeHistoryScreenState.Loading
    )

    init {
        onAction(OutcomeHistoryScreenAction.GetData(
            startDate = "2025-06-01",
            endDate = "2025-06-30"
        ))
    }

    override fun onAction(action: OutcomeHistoryScreenAction) {
        when (action) {
            OutcomeHistoryScreenAction.OnBackClicked -> {
                viewModelScope.launch {
                    updateEffect(OutcomeHistoryScreenEffect.NavigateBack)
                }
            }

            OutcomeHistoryScreenAction.OnCalendarClicked -> {
                viewModelScope.launch {
                    updateState(
                        OutcomeHistoryScreenState.Content(
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

            is OutcomeHistoryScreenAction.GetData -> {
                getOutcomeData(action.startDate, action.endDate)
            }
        }
    }

    private fun getOutcomeData(startDate: String, endDate: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(OutcomeHistoryScreenState.Loading)
            val result = getOutcomeDataUseCase.invoke(startDate, endDate)
            when (result) {
                ObtainOutcomeData.Error -> updateState(OutcomeHistoryScreenState.Error)
                is ObtainOutcomeData.Success-> {
                    if (result.transactions.isNotEmpty()){
                        updateState(
                            OutcomeHistoryScreenState.Content(
                                startDate = startDate,
                                endDate = endDate,
                                amount = result.allOutcome.formattedAmount,
                                currency = result.allOutcome.currency,
                                allTransactions = result.transactions,
                                isDatePicker = false
                            )
                        )
                    }else{
                        updateState(
                            OutcomeHistoryScreenState.Empty
                        )
                    }
                }
            }
        }
    }
}
