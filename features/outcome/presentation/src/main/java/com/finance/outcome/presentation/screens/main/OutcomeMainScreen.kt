package com.finance.outcome.presentation.screens.main

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
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.ext.collectAsEffect
import com.finance.common.ui.theme.FinanceAppTheme
import com.finance.outcome.presentation.R
import com.finance.outcome.presentation.navigation.OutcomeFeatureScreens
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenAction
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenEffect
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenState
import com.finance.outcome.presentation.screens.main.states.OutcomeMainScreenContentState
import com.finance.outcome.presentation.screens.main.states.OutcomeMainScreenEmptyState
import com.finance.outcome.presentation.screens.main.states.OutcomeMainScreenErrorState
import com.finance.outcome.presentation.screens.main.states.OutcomeMainScreenLoadingState

@Composable
fun OutcomeMainScreen(
    navController: NavController,
    viewModel: OutcomeMainScreenViewModel,
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect {
        when (it) {
            OutcomeMainScreenEffect.NavigateToHistoryScreen -> {
                navController.navigate(OutcomeFeatureScreens.HistoryOutcomeScreen.route)
            }
        }
    }

    OutcomeMainScreenContent(
        state, viewModel::onAction
    )
}

@Composable
fun OutcomeMainScreenContent(
    state: OutcomeMainScreenState,
    onAction: (OutcomeMainScreenAction) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        FeatureTopBar(R.string.outcome_top_bar, actionButton = {
            IconButton(
                {
                    onAction(OutcomeMainScreenAction.OnHistoryClicked)
                },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    painterResource(com.finance.common.ui.R.drawable.history_ic),
                    "",
                    tint = FinanceAppTheme.colors.onSurface
                )
            }
        }, modifier = Modifier)

        when (state) {
            is OutcomeMainScreenState.Content -> OutcomeMainScreenContentState(
                categories = state.categories,
                allOutcome = state.allOutcome,
                onAction = onAction
            )

            OutcomeMainScreenState.Empty -> OutcomeMainScreenEmptyState()
            OutcomeMainScreenState.Error -> OutcomeMainScreenErrorState({
                onAction(OutcomeMainScreenAction.OnScreenEntered)
            })

            OutcomeMainScreenState.Loading -> OutcomeMainScreenLoadingState()
        }
    }
}
