package com.finance.outcome.presentation.screens.main.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.ErrorStateWidget
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenState

@Composable
fun OutcomeMainScreenErrorState(refresh: () -> Unit) {
    ErrorStateWidget(refresh, Modifier.fillMaxSize())
}