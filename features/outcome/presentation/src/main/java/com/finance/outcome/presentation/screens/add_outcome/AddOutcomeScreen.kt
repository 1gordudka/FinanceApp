package com.finance.outcome.presentation.screens.add_outcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.finance.common.ui.R
import com.finance.common.ui.components.ExtraTopBar
import com.finance.common.ui.ext.collectAsEffect
import com.finance.common.ui.theme.FinanceAppTheme
import com.finance.outcome.presentation.screens.add_outcome.models.OutcomeScreenMode
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenAction
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenEffect
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenState
import com.finance.outcome.presentation.screens.add_outcome.states.AddOutcomeScreenContentState
import com.finance.outcome.presentation.screens.add_outcome.states.AddOutcomeScreenErrorState
import com.finance.outcome.presentation.screens.add_outcome.states.AddOutcomeScreenLoadingState

@Composable
fun AddOutcomeScreen(
    navController: NavController,
    viewModel: AddOutcomeScreenViewModel,
    mode: OutcomeScreenMode
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect {
        when (it) {
            AddOutcomeScreenEffect.NavigateBack -> {
                navController.popBackStack()
            }
        }
    }

    AddOutcomeScreenContent(
        state, viewModel::onAction, mode
    )
}

@Composable
fun AddOutcomeScreenContent(
    state: AddOutcomeScreenState,
    onAction: (AddOutcomeScreenAction) -> Unit,
    mode: OutcomeScreenMode
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ExtraTopBar(
            name = when (mode) {
                is OutcomeScreenMode.Create -> "Добавить расход"
                is OutcomeScreenMode.Edit -> "Редактировать расход"
                is OutcomeScreenMode.EditById -> "Редактировать расход"
            },
            firstAction = {
                IconButton({
                    onAction(AddOutcomeScreenAction.OnBackButton)
                }) {
                    Icon(
                        painterResource(R.drawable.back_ic), "",
                        tint = FinanceAppTheme.colors.onSurface
                    )
                }
            },
            secondAction = {
                IconButton({
                    onAction(AddOutcomeScreenAction.OnCreateButton)
                }) {
                    Icon(
                        Icons.Default.Check, "",
                        tint = FinanceAppTheme.colors.onSurface
                    )
                }
            },
        )

        when (state) {
            is AddOutcomeScreenState.Content -> {
                AddOutcomeScreenContentState(state, onAction)
            }
            AddOutcomeScreenState.Loading -> {
                AddOutcomeScreenLoadingState()
            }
            AddOutcomeScreenState.Error -> {
                AddOutcomeScreenErrorState {
                    onAction(AddOutcomeScreenAction.OnRetryButton)
                }
            }
        }
    }
} 