package com.finance.articles.presentation.screens.main.states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.finance.articles.domain.models.ArticleCategory
import com.finance.articles.presentation.screens.main.components.ArticleCategoryCard
import com.finance.articles.presentation.screens.main.state_hoisting.ArticlesMainScreenAction
import com.finance.common.ui.components.GrayDivider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesMainScreenContentState(
    articles: List<ArticleCategory>,
    onAction: (ArticlesMainScreenAction) -> Unit
) {


    var searchQuery by rememberSaveable { mutableStateOf("") }

    com.finance.articles.presentation.screens.main.components.SearchBar(
        searchQuery,
        onSearchClick = {},
        searchExit = {
            onAction(ArticlesMainScreenAction.OnSearchExit)
        },
        onQueryChange = {
            searchQuery = it
            onAction(ArticlesMainScreenAction.OnSearchQuery(it.lowercase()))
        })

    LazyColumn {
        item {
            GrayDivider()
        }
        items(articles) {
            ArticleCategoryCard(it.name, it.emoji) { }
            GrayDivider()
        }
    }

}