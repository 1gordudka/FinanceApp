package com.finance.outcome.presentation.screens.history.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.ErrorStateWidget

@Composable
fun OutcomeHistoryScreenErrorState (
    refresh: () -> Unit
){

    ErrorStateWidget(refresh, Modifier.fillMaxSize())
}