package com.finance.income.presentation.screens.add_income.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.ErrorStateWidget

@Composable
fun AddIncomeScreenErrorState(onRetry: () -> Unit) {
    ErrorStateWidget(onRetry, Modifier.fillMaxSize())
} 