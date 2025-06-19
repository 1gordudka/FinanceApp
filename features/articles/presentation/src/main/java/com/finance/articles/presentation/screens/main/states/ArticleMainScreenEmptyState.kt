package com.finance.articles.presentation.screens.main.states

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenState
import com.finance.common.ui.components.EmptyStateWidget

@Composable
fun ArticlesMainScreenEmptyState() {
    EmptyStateWidget(Modifier.fillMaxSize())
}