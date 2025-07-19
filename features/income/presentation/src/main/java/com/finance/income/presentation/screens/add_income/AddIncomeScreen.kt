package com.finance.income.presentation.screens.add_income

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
import com.finance.income.presentation.screens.add_income.models.IncomeScreenMode
import com.finance.income.presentation.screens.add_income.state_hoisting.AddIncomeScreenAction
import com.finance.income.presentation.screens.add_income.state_hoisting.AddIncomeScreenEffect
import com.finance.income.presentation.screens.add_income.state_hoisting.AddIncomeScreenState
import com.finance.income.presentation.screens.add_income.states.AddIncomeScreenContentState
import com.finance.income.presentation.screens.add_income.states.AddIncomeScreenErrorState
import com.finance.income.presentation.screens.add_income.states.AddIncomeScreenLoadingState

@Composable
fun AddIncomeScreen(
    navController: NavController,
    viewModel: AddIncomeScreenViewModel,
    mode: IncomeScreenMode
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect {
        when (it) {
            AddIncomeScreenEffect.NavigateBack -> {
                navController.popBackStack()
            }
        }
    }

    AddIncomeScreenContent(
        state, viewModel::onAction, mode
    )
}

@Composable
fun AddIncomeScreenContent(
    state: AddIncomeScreenState,
    onAction: (AddIncomeScreenAction) -> Unit,
    mode: IncomeScreenMode
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ExtraTopBar(
            name = when (mode) {
                is IncomeScreenMode.Create -> "Добавить доход"
                is IncomeScreenMode.Edit -> "Редактировать доход"
                is IncomeScreenMode.EditById -> "Редактировать доход"
            },
            firstAction = {
                IconButton({
                    onAction(AddIncomeScreenAction.OnBackButton)
                }) {
                    Icon(
                        painterResource(R.drawable.back_ic), "",
                        tint = FinanceAppTheme.colors.onSurface
                    )
                }
            },
            secondAction = {
                IconButton({
                    onAction(AddIncomeScreenAction.OnCreateButton)
                }) {
                    Icon(
                        Icons.Default.Check, "",
                        tint = FinanceAppTheme.colors.onSurface
                    )
                }
            },
        )

        when (state) {
            is AddIncomeScreenState.Content -> {
                AddIncomeScreenContentState(
                    amount = state.amount,
                    categoryId = state.categoryId,
                    comment = state.comment,
                    date = state.date,
                    changeAmount = {
                        onAction(AddIncomeScreenAction.ChangeAmount(amount = it))
                    },
                    changeCategoryId = {
                        onAction(AddIncomeScreenAction.ChangeCategoryId(it))
                    },
                    changeComment = {
                        onAction(AddIncomeScreenAction.ChangeComment(it))
                    },
                    changeDate = {
                        onAction(AddIncomeScreenAction.ChangeDate(it))
                    },
                    accountId = state.accountId,
                    changeAccountId = {
                        onAction(AddIncomeScreenAction.ChangeAccountId(it))
                    }
                )
            }

            AddIncomeScreenState.Error -> AddIncomeScreenErrorState { 
                onAction(AddIncomeScreenAction.OnRetryButton)
            }

            AddIncomeScreenState.Loading -> AddIncomeScreenLoadingState()
        }
    }
} 