package com.finance.articles.presentation.screens.main.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.ErrorStateWidget

@Composable
fun ArticlesMainScreenErrorState(
    refresh: () -> Unit
) {

    ErrorStateWidget(refresh, Modifier.fillMaxSize())
}