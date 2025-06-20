package com.finance.articles.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.articles.data.mock.allArticles
import com.finance.articles.domain.models.results.ObtainAllCategoriesResult
import com.finance.articles.domain.models.use_cases.GetCategoriesUseCase
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenAction
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenEffect
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenState
import com.finance.common.ui.state_hoisting.StatefulViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticlesMainScreenViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) :
    StatefulViewModel<ArticlesMainScreenState, ArticlesMainScreenEffect, ArticlesMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, ArticlesMainScreenState.Loading
    )

    init {
        onAction(ArticlesMainScreenAction.OnScreenEntered)
    }

    override fun onAction(action: ArticlesMainScreenAction) {
        when (action) {
            ArticlesMainScreenAction.OnScreenEntered -> {
               getAllArticles()
            }
        }
    }

    private fun getAllArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            updateState(ArticlesMainScreenState.Loading)
            when (val result = getCategoriesUseCase.invoke()) {
                ObtainAllCategoriesResult.Error -> {
                    updateState(ArticlesMainScreenState.Error)
                }

                is ObtainAllCategoriesResult.Success -> {
                    updateState(ArticlesMainScreenState.Content(result.categories))
                }
            }
        }
    }
}
