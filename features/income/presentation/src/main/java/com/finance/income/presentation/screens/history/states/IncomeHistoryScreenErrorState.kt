package com.finance.income.presentation.screens.history.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.ErrorStateWidget

@Composable
fun IncomeHistoryScreenErrorState(
    refresh: () -> Unit
) {
    ErrorStateWidget(refresh, Modifier.fillMaxSize())
} 