package com.finance.income.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
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
import com.finance.income.presentation.R
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenAction
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenState
import com.finance.income.presentation.screens.main.states.IncomeMainScreenContentState
import com.finance.income.presentation.screens.main.states.IncomeMainScreenEmptyState
import com.finance.income.presentation.screens.main.states.IncomeMainScreenErrorState
import com.finance.income.presentation.screens.main.states.IncomeMainScreenLoadingState

@Composable
fun IncomeMainScreen(
    navController: NavController,
    viewModel: IncomeMainScreenViewModel,
) {

    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect {

    }


    IncomeMainScreenContent(
        state, viewModel::onAction
    )
}

@Composable
fun IncomeMainScreenContent(
    state: IncomeMainScreenState,
    onAction: (IncomeMainScreenAction) -> Unit
) {

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        FeatureTopBar(
            featureNameId = R.string.top_bar,
            actionButton = {
                IconButton(
                    {},
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painterResource(com.finance.common.ui.R.drawable.history_ic),
                        "",
                        tint = FinanceAppTheme.colors.onSurface
                    )
                }
            },
            modifier = Modifier
        )

        when (state) {
            is IncomeMainScreenState.Content -> {
                IncomeMainScreenContentState(
                    categories = state.categories,
                    allIncome = state.allIncome
                ) {
                    onAction(it)
                }
            }

            IncomeMainScreenState.Empty -> {
                IncomeMainScreenEmptyState()
            }

            IncomeMainScreenState.Error -> {
                IncomeMainScreenErrorState()
            }

            IncomeMainScreenState.Loading -> {
                IncomeMainScreenLoadingState()
            }
        }
    }

}