package com.finance.articles.presentation.screens.main.state_hoisting

sealed class ArticlesMainScreenAction {

    data object OnScreenEntered: ArticlesMainScreenAction()

    data class OnSearchQuery(val q: String,): ArticlesMainScreenAction()

    data object OnSearchExit: ArticlesMainScreenAction()
}