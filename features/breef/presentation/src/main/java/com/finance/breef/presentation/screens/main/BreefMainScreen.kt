package com.finance.breef.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.finance.breef.data.mock.balance
import com.finance.breef.presentation.R
import com.finance.breef.presentation.screens.main.state_hoisting.BreefMainScreenAction
import com.finance.breef.presentation.screens.main.state_hoisting.BreefMainScreenState
import com.finance.breef.presentation.screens.main.states.BreefMainScreenContentState
import com.finance.breef.presentation.screens.main.states.BreefMainScreenEmptyState
import com.finance.breef.presentation.screens.main.states.BreefMainScreenErrorState
import com.finance.breef.presentation.screens.main.states.BreefMainScreenLoadingState
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.ext.collectAsEffect

@Composable
fun BreefMainScreen(
    navController: NavController,
    viewModel: BreefMainScreenViewModel,
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect { }

    BreefMainScreenContent(
        state, viewModel::onAction
    )
}

@Composable
fun BreefMainScreenContent(
    state: BreefMainScreenState,
    onAction: (BreefMainScreenAction) -> Unit
) {
    Column(Modifier.fillMaxSize().background(Color.White)) {
        FeatureTopBar(R.string.breef_top_bar, actionButton = { }, modifier = Modifier)

        when (state) {
            is BreefMainScreenState.Content -> BreefMainScreenContentState(
                balance = state.balance.formattedAmount,
                currency = state.balance.currency,
                onAction = onAction
            )
            BreefMainScreenState.Empty -> BreefMainScreenEmptyState()
            BreefMainScreenState.Error -> BreefMainScreenErrorState()
            BreefMainScreenState.Loading -> BreefMainScreenLoadingState()
        }
    }
}
