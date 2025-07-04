package com.finance.articles.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.articles.domain.models.ArticleCategory
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

class ArticlesMainScreenViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) :
    StatefulViewModel<ArticlesMainScreenState, ArticlesMainScreenEffect, ArticlesMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, ArticlesMainScreenState.Loading
    )

    private var articlesBeforeSearch = emptyList<ArticleCategory>()

    init {
        onAction(ArticlesMainScreenAction.OnScreenEntered)
    }

    override fun onAction(action: ArticlesMainScreenAction) {
        when (action) {
            ArticlesMainScreenAction.OnScreenEntered -> {
                getAllArticles()
            }

            ArticlesMainScreenAction.OnSearchExit -> {
                searchExit()
            }

            is ArticlesMainScreenAction.OnSearchQuery -> {
                searchArticle(q = action.q)
            }
        }
    }

    private fun searchExit() {

        viewModelScope.launch {

            updateState(
                ArticlesMainScreenState.Content(articlesBeforeSearch)
            )
        }
    }

    private fun searchArticle(q: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val articlesForSearch = articlesBeforeSearch.filter { it.name.lowercase().contains(q) }

            updateState(
                ArticlesMainScreenState.Content(articlesForSearch)
            )
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
                    articlesBeforeSearch =
                        result.categories
                    updateState(ArticlesMainScreenState.Content(result.categories))
                }
            }
        }
    }
}
