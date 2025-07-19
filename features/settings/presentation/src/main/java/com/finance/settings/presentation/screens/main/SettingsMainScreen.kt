package com.finance.settings.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.ext.collectAsEffect
import com.finance.settings.presentation.R
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenAction
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenState
import com.finance.settings.presentation.screens.main.states.SettingsMainScreenContentState
import com.finance.settings.presentation.screens.main.states.SettingsMainScreenEmptyState
import com.finance.settings.presentation.screens.main.states.SettingsMainScreenErrorState
import com.finance.settings.presentation.screens.main.states.SettingsMainScreenLoadingState

@Composable
fun SettingsMainScreen(
    navController: NavController,
    viewModel: SettingsMainScreenViewModel,
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect { }

    SettingsMainScreenContent(
        state, viewModel::onAction
    )
}

@Composable
fun SettingsMainScreenContent(
    state: SettingsMainScreenState,
    onAction: (SettingsMainScreenAction) -> Unit
) {
    Column(Modifier
        .fillMaxSize()
        .background(Color.White)) {
        FeatureTopBar(R.string.settings_top_bar, actionButton = { }, modifier = Modifier)

        when (state) {
            is SettingsMainScreenState.Content -> SettingsMainScreenContentState(
                settings = state.settings,
                syncStatus = state.syncStatus,
                onAction = onAction
            )

            SettingsMainScreenState.Empty -> SettingsMainScreenEmptyState()
            SettingsMainScreenState.Error -> SettingsMainScreenErrorState()
            SettingsMainScreenState.Loading -> SettingsMainScreenLoadingState()
        }
    }
}
