package com.finance.outcome.presentation.screens.add_outcome.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.common.ui.components.ShimmerEffectCard

@Composable
fun AddOutcomeScreenLoadingState() {
    ShimmerEffectCard(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
    )
} 