package com.finance.brief.presentation.screens.create.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.common.ui.components.ShimmerEffectCard

@Composable
fun CreateAccountScreenLoadingState() {
    ShimmerEffectCard(Modifier.padding(16.dp).fillMaxSize())
}