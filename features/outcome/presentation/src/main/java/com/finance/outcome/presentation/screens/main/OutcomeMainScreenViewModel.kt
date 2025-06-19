package com.finance.outcome.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.outcome.data.remote.mappers.incomeCategoryToUIMapper
import com.finance.outcome.domain.results.ObtainOutcomeData
import com.finance.outcome.domain.use_cases.GetTodayOutcomeDataUseCase
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenAction
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenEffect
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class OutcomeMainScreenViewModel(
    private val getTodayOutcomeDataUseCase: GetTodayOutcomeDataUseCase
) :
    StatefulViewModel<OutcomeMainScreenState, OutcomeMainScreenEffect, OutcomeMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, OutcomeMainScreenState.Loading
    )

    init {

        onAction(OutcomeMainScreenAction.OnScreenEntered)
    }

    override fun onAction(action: OutcomeMainScreenAction) {
        when (action) {
            OutcomeMainScreenAction.OnHistoryClicked -> {
                viewModelScope.launch {
                    updateEffect(
                        OutcomeMainScreenEffect.NavigateToHistoryScreen
                    )
                }
            }

            OutcomeMainScreenAction.OnScreenEntered -> {
                loadOutcomeData()
            }
        }
    }

    private fun loadOutcomeData() {

        viewModelScope.launch(Dispatchers.IO) {
            updateState(OutcomeMainScreenState.Loading)
            val result = getTodayOutcomeDataUseCase.invoke(getTodayDate())
            when (result) {
                ObtainOutcomeData.Error -> updateState(OutcomeMainScreenState.Error)
                is ObtainOutcomeData.Success -> {
                    updateState(
                        OutcomeMainScreenState.Content(
                            allOutcome = result.allOutcome,
                            categories = incomeCategoryToUIMapper(result.transactions)
                        )
                    )
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

