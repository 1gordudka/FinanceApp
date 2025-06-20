package com.finance.brief.presentation.screens.create

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
import com.finance.brief.presentation.R
import com.finance.brief.presentation.navigation.BriefFeatureScreens
import com.finance.brief.presentation.screens.create.state_hoisting.CreateAccountScreenAction
import com.finance.brief.presentation.screens.create.state_hoisting.CreateAccountScreenEffect
import com.finance.brief.presentation.screens.create.state_hoisting.CreateAccountScreenState
import com.finance.brief.presentation.screens.create.states.CreateAccountScreenContentState
import com.finance.brief.presentation.screens.create.states.CreateAccountScreenErrorState
import com.finance.brief.presentation.screens.create.states.CreateAccountScreenLoadingState
import com.finance.brief.presentation.screens.main.BriefMainScreenContent
import com.finance.brief.presentation.screens.main.BriefMainScreenViewModel
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenAction
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenContentState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenEmptyState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenErrorState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenLoadingState
import com.finance.common.ui.components.ExtraTopBar
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.ext.collectAsEffect
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun CreateAccountScreen(
    navController: NavController,
    viewModel: CreateAccountScreenViewModel,
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect {
        when (it) {
            CreateAccountScreenEffect.NavigateBack -> {
                navController.popBackStack()
            }
        }
    }

    CreateAccountScreenContent(
        state, viewModel::onAction
    )
}

@Composable
fun CreateAccountScreenContent(
    state: CreateAccountScreenState,
    onAction: (CreateAccountScreenAction) -> Unit
) {

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ExtraTopBar(
            name = "Создать счет",
            firstAction = {
                IconButton({
                    onAction(CreateAccountScreenAction.OnBackButton)
                }) {
                    Icon(
                        painterResource(com.finance.common.ui.R.drawable.back_ic), "",
                        tint = FinanceAppTheme.colors.onSurface
                    )
                }
            },
            secondAction = {
                IconButton({
                    onAction(CreateAccountScreenAction.OnCreateButton)
                }) {
                    Icon(
                        Icons.Default.Check, "",
                        tint = FinanceAppTheme.colors.onSurface
                    )
                }
            },
        )

        when (state) {
            is CreateAccountScreenState.Content -> {
                CreateAccountScreenContentState(
                    name = state.name,
                    amount = state.amount,
                    currency = state.currency,
                    changeName = {
                        onAction(CreateAccountScreenAction.ChangeName(name = it))
                    },
                    changeAmount = {
                        onAction(CreateAccountScreenAction.ChangeAmount(it))
                    },
                    changeCurrency = {
                        onAction(CreateAccountScreenAction.ChangeCurrency(it))
                    }
                )
            }

            CreateAccountScreenState.Error -> CreateAccountScreenErrorState { }

            CreateAccountScreenState.Loading -> CreateAccountScreenLoadingState()
        }
    }

}