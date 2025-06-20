package com.finance.outcome.presentation.screens.main.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.common.ui.components.ShimmerEffectCard
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenState

@Composable
fun OutcomeMainScreenLoadingState() {
    ShimmerEffectCard(Modifier
        .padding(16.dp)
        .fillMaxSize())
}