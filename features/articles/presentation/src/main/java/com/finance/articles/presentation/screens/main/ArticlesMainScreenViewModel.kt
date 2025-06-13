package com.finance.articles.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.articles.data.mock.allArticles
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenAction
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenEffect
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenState
import com.finance.common.ui.state_hoisting.StatefulViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

class ArticlesMainScreenViewModel() :
    StatefulViewModel<ArticlesMainScreenState, ArticlesMainScreenEffect, ArticlesMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, ArticlesMainScreenState.Content(
            articles = allArticles
        )
    )

    override fun onAction(action: ArticlesMainScreenAction) {
        // handle articles actions here
    }
}
