package com.finance.brief.presentation.screens.main.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.EmptyStateWidget

@Composable
fun BriefMainScreenEmptyState() {
    EmptyStateWidget(Modifier.fillMaxSize())
}