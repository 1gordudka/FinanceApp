package com.finance.income.presentation.screens.history

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
import com.finance.income.presentation.R
import com.finance.income.presentation.navigation.IncomeFeatureScreens
import com.finance.income.presentation.screens.history.state_hoisting.IncomeHistoryScreenAction
import com.finance.income.presentation.screens.history.state_hoisting.IncomeHistoryScreenEffect
import com.finance.income.presentation.screens.history.state_hoisting.IncomeHistoryScreenState
import com.finance.income.presentation.screens.history.states.IncomeHistoryScreenContentState
import com.finance.income.presentation.screens.history.states.IncomeHistoryScreenEmptyState
import com.finance.income.presentation.screens.history.states.IncomeHistoryScreenErrorState
import com.finance.income.presentation.screens.history.states.IncomeHistoryScreenLoadingState
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun IncomeHistoryScreen(
    navController: NavController,
    viewModel: IncomeHistoryScreenViewModel,
) {

    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect {
        when (it) {
            IncomeHistoryScreenEffect.NavigateBack -> {
                navController.popBackStack()
            }
            is IncomeHistoryScreenEffect.NavigateToEditIncome -> {
                navController.navigate(IncomeFeatureScreens.createEditIncomeRoute(it.transaction.id))
            }
        }
    }


    IncomeHistoryScreenContent(
        state = state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomeHistoryScreenContent(
    state: IncomeHistoryScreenState,
    onAction: (IncomeHistoryScreenAction) -> Unit
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
                            onAction(IncomeHistoryScreenAction.OnBackClicked)
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
                            onAction(IncomeHistoryScreenAction.OnCalendarClicked)
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
                is IncomeHistoryScreenState.Content -> {
                    IncomeHistoryScreenContentState(
                        startDate = state.startDate,
                        endDate = state.endDate,
                        amount = state.amount,
                        currency = state.currency,
                        transactions = state.allTransactions,
                        onTransactionClick = { transaction ->
                            onAction(IncomeHistoryScreenAction.OnTransactionClicked(transaction))
                        }
                    )
                }

                IncomeHistoryScreenState.Empty -> IncomeHistoryScreenEmptyState()
                IncomeHistoryScreenState.Error -> IncomeHistoryScreenErrorState({

                })

                IncomeHistoryScreenState.Loading -> IncomeHistoryScreenLoadingState()
            }
        }
        if (state is IncomeHistoryScreenState.Content) {
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
                            onAction(IncomeHistoryScreenAction.OnCalendarClicked)
                        }) {
                            Text(
                                "Отмена",
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.Black
                            )
                        }
                        TextButton({
                            if (pickerState.selectedEndDateMillis != null && pickerState.selectedStartDateMillis != null){
                                onAction(
                                    IncomeHistoryScreenAction.GetData(
                                        startDate = formatMillisToDate(pickerState.selectedStartDateMillis!!),
                                        endDate = formatMillisToDate(pickerState.selectedEndDateMillis!!)
                                    )
                                )
                                onAction(IncomeHistoryScreenAction.OnCalendarClicked)
                            }
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
