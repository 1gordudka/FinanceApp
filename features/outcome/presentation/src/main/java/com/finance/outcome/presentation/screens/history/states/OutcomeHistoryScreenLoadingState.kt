package com.finance.outcome.presentation.screens.history.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.common.ui.components.ShimmerEffectCard

@Composable
fun OutcomeHistoryScreenLoadingState() {

    ShimmerEffectCard(Modifier
        .padding(16.dp)
        .fillMaxSize())
}