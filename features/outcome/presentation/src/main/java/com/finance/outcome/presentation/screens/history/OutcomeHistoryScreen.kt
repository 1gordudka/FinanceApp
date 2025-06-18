package com.finance.outcome.presentation.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

@Composable
fun OutcomeHistoryScreenContent(
    state: OutcomeHistoryScreenState,
    onAction: (OutcomeHistoryScreenAction) -> Unit
) {

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
                    onTransactionClick = {  }
                )
            }

            OutcomeHistoryScreenState.Empty -> OutcomeHistoryScreenEmptyState()
            OutcomeHistoryScreenState.Error -> OutcomeHistoryScreenErrorState()
            OutcomeHistoryScreenState.Loading -> OutcomeHistoryScreenLoadingState()
        }
    }

}