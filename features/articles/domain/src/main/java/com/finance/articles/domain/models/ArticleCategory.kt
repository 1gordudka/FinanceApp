package com.finance.articles.domain.models

sealed class ArticleCategory{

    data class ArticleCategoryLead(
        val emoji: String,
        val name: String,
    ) : ArticleCategory()
}

