package com.finance.brief.presentation.screens.main.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.ErrorStateWidget

@Composable
fun BriefMainScreenErrorState(
    refresh: () -> Unit
) {

    ErrorStateWidget(refresh, modifier = Modifier.fillMaxSize())
}