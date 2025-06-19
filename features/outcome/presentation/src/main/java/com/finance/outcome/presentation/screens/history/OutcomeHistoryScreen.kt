package com.finance.outcome.presentation.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.finance.common.ui.components.ExtraTopBar
import com.finance.common.ui.ext.collectAsEffect
import com.finance.common.ui.theme.FinanceAppTheme
import com.finance.outcome.presentation.R
import com.finance.outcome.presentation.screens.history.di.OutcomeHistoryScreenModule
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenAction
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenEffect
import com.finance.outcome.presentation.screens.history.state_hoisting.OutcomeHistoryScreenState
import com.finance.outcome.presentation.screens.history.states.OutcomeHistoryScreenContentState
import com.finance.outcome.presentation.screens.history.states.OutcomeHistoryScreenEmptyState
import com.finance.outcome.presentation.screens.history.states.OutcomeHistoryScreenErrorState
import com.finance.outcome.presentation.screens.history.states.OutcomeHistoryScreenLoadingState
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun OutcomeHistoryScreen(
    navController: NavController,
    viewModel: OutcomeHistoryScreenViewModel,
) {

    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect {
        when (it) {
            OutcomeHistoryScreenEffect.NavigateBack -> {
                navController.popBackStack()
            }
        }
    }

    OutcomeHistoryScreenContent(
        state = state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutcomeHistoryScreenContent(
    state: OutcomeHistoryScreenState,
    onAction: (OutcomeHistoryScreenAction) -> Unit
) {

    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            ExtraTopBar(
                name = "Моя история",
                firstAction = {
                    IconButton(
                        {
                            onAction(OutcomeHistoryScreenAction.OnBackClicked)
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            painterResource(com.finance.common.ui.R.drawable.back_ic),
                            "",
                            tint = FinanceAppTheme.colors.onSurface
                        )
                    }
                },
                secondAction = {
                    IconButton(
                        {
                            onAction(OutcomeHistoryScreenAction.OnCalendarClicked)
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            painterResource(R.drawable.calendar_ic),
                            "",
                            tint = FinanceAppTheme.colors.onSurface
                        )
                    }
                },
                modifier = Modifier
            )

            when (state) {
                is OutcomeHistoryScreenState.Content -> {
                    OutcomeHistoryScreenContentState(
                        startDate = state.startDate,
                        endDate = state.endDate,
                        amount = state.amount,
                        currency = state.currency,
                        transactions = state.allTransactions,
                        onTransactionClick = { }
                    )
                }

                OutcomeHistoryScreenState.Empty -> OutcomeHistoryScreenEmptyState()
                OutcomeHistoryScreenState.Error -> OutcomeHistoryScreenErrorState(
                    {

                    }
                )
                OutcomeHistoryScreenState.Loading -> OutcomeHistoryScreenLoadingState()
            }
        }
        if (state is OutcomeHistoryScreenState.Content) {
            if (state.isDatePicker) {
                val pickerState = rememberDateRangePickerState()
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(0.7f))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DateRangePicker(
                        pickerState, modifier = Modifier
                            .height(500.dp)
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
                            ), colors = DatePickerDefaults.colors(
                            containerColor = Color(0xFFD4FAE6),
                            selectedDayContentColor = Color.Black,
                            selectedDayContainerColor = Color(0xFF2AE881),
                            dayInSelectionRangeContainerColor = Color(0xFF2AE881),
                            todayDateBorderColor = Color(0xFF2AE881)
                        )
                    )
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp))
                            .background(Color(0xFFD4FAE6))
                            .height(60.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TextButton({
                            onAction(OutcomeHistoryScreenAction.OnCalendarClicked)
                        }) {
                            Text(
                                "Отмена",
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.Black
                            )
                        }
                        TextButton({
                            onAction(
                                OutcomeHistoryScreenAction.GetData(
                                    startDate = formatMillisToDate(pickerState.selectedStartDateMillis!!),
                                    endDate = formatMillisToDate(pickerState.selectedEndDateMillis!!)
                                )
                            )
                            onAction(OutcomeHistoryScreenAction.OnCalendarClicked)
                        }) {
                            Text(
                                "Готово",
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }


}

fun formatMillisToDate(millis: Long): String {
    val date = Instant.ofEpochMilli(millis)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return date.format(formatter)
}