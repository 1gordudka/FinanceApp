package com.finance.brief.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.finance.brief.presentation.R
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenAction
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenContentState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenEmptyState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenErrorState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenLoadingState
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.ext.collectAsEffect
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun BriefMainScreen(
    navController: NavController,
    viewModel: BriefMainScreenViewModel,
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect { }

    BriefMainScreenContent(
        state, viewModel::onAction
    )
}

@Composable
fun BriefMainScreenContent(
    state: BriefMainScreenState,
    onAction: (BriefMainScreenAction) -> Unit
) {
    Column(Modifier
        .fillMaxSize()
        .background(Color.White)) {
        FeatureTopBar(R.string.brief_top_bar, actionButton = {
            IconButton({}) {
                Icon(
                    painterResource(com.finance.common.ui.R.drawable.edit_ic), "",
                    tint = FinanceAppTheme.colors.onSurface
                )
            }
        }, modifier = Modifier)

        when (state) {
            is BriefMainScreenState.Content -> BriefMainScreenContentState(
                balance = state.balance.formattedAmount,
                currency = state.balance.currency,
                onAction = onAction
            )

            BriefMainScreenState.Empty -> BriefMainScreenEmptyState()
            BriefMainScreenState.Error -> BriefMainScreenErrorState({
                onAction(BriefMainScreenAction.OnScreenEntered)
            })

            BriefMainScreenState.Loading -> BriefMainScreenLoadingState()
        }
    }
}
