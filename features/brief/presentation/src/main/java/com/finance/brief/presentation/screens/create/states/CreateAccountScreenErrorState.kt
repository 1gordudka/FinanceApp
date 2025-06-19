package com.finance.brief.presentation.screens.create.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.ErrorStateWidget

@Composable
fun CreateAccountScreenErrorState(refresh: () -> Unit) {
    ErrorStateWidget(refresh, Modifier.fillMaxSize())
}