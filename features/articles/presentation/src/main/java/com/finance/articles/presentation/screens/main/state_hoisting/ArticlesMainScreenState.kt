package com.finance.articles.presentation.screens.main.state_hoisting

import com.finance.articles.domain.models.ArticleCategory

sealed class ArticlesMainScreenState {

    data class Content(
        val articles: List<ArticleCategory.ArticleCategoryLead>
    ) : ArticlesMainScreenState()

    data object Loading : ArticlesMainScreenState()

    data object Empty : ArticlesMainScreenState()

    data object Error : ArticlesMainScreenState()
}
