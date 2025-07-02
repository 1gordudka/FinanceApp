package com.finance.brief.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.finance.brief.data.mock.balance
import com.finance.brief.presentation.R
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenAction
import com.finance.brief.presentation.screens.main.state_hoisting.BriefMainScreenState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenContentState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenEmptyState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenErrorState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenLoadingState
import com.finance.brief.presentation.screens.main.states.BriefMainScreenUpdateState
import com.finance.common.ui.components.ExtraTopBar
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


    var isEditFinished by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (state is BriefMainScreenState.Update) {
            ExtraTopBar(
                name = balance.name,
                firstAction = {
                    IconButton({
                        onAction(BriefMainScreenAction.OnExitEdit)
                    }) {
                        Icon(
                            Icons.Rounded.Close, "",
                            tint = FinanceAppTheme.colors.onSurface
                        )
                    }
                },
                secondAction = {

                    IconButton({
                        isEditFinished = true
                    }) {
                        Icon(
                            Icons.Rounded.Done, "",
                            tint = FinanceAppTheme.colors.onSurface
                        )
                    }
                },
                modifier = Modifier
            )
        } else {
            FeatureTopBar(
                featureNameId = if (state is BriefMainScreenState.Content) null else R.string.brief_top_bar,
                name = if (state is BriefMainScreenState.Content) balance.name else null,
                actionButton = {
                    if (state is BriefMainScreenState.Content){
                        IconButton({
                            onAction(BriefMainScreenAction.OnEditButton)
                        }) {
                            Icon(
                                painterResource(com.finance.common.ui.R.drawable.edit_ic), "",
                                tint = FinanceAppTheme.colors.onSurface
                            )
                        }
                    }
                },
                modifier = Modifier
            )
        }

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
            is BriefMainScreenState.Update -> {
                BriefMainScreenUpdateState(
                    name = state.balance.name,
                    balance = state.balance.formattedAmount,
                    currency = state.balance.currency,
                    isDoneClicked = isEditFinished,
                    onDoneClick = {
                        onAction(
                            BriefMainScreenAction.OnUpdateInfo(
                                balance = it
                            )
                        )
                        isEditFinished = false
                    }
                )
            }
        }
    }
}
