package com.finance.articles.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.finance.articles.presentation.R
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenAction
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenState
import com.finance.articles.presentation.screens.main.states.ArticlesMainScreenContentState
import com.finance.articles.presentation.screens.main.states.ArticlesMainScreenEmptyState
import com.finance.articles.presentation.screens.main.states.ArticlesMainScreenErrorState
import com.finance.articles.presentation.screens.main.states.ArticlesMainScreenLoadingState
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.ext.collectAsEffect
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun ArticlesMainScreen(
    navController: NavController,
    viewModel: ArticlesMainScreenViewModel,
) {
    val state by viewModel.state.collectAsState()
    viewModel.effect.collectAsEffect { }

    ArticlesMainScreenContent(
        state, viewModel::onAction
    )
}

@Composable
fun ArticlesMainScreenContent(
    state: ArticlesMainScreenState,
    onAction: (ArticlesMainScreenAction) -> Unit
) {
    Column(Modifier.fillMaxSize().background(Color.White)) {
        FeatureTopBar(R.string.articles_top_bar, actionButton = {
            IconButton({}) {
                Icon(painterResource(com.finance.common.ui.R.drawable.edit_ic), "",
                    tint = FinanceAppTheme.colors.onSurface)
            }
        }, modifier = Modifier)

        when (state) {
            is ArticlesMainScreenState.Content -> ArticlesMainScreenContentState(
                articles = state.articles,
                onAction = onAction
            )
            ArticlesMainScreenState.Empty -> ArticlesMainScreenEmptyState()
            ArticlesMainScreenState.Error -> ArticlesMainScreenErrorState()
            ArticlesMainScreenState.Loading -> ArticlesMainScreenLoadingState()
        }
    }
}
