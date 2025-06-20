package com.finance.articles.domain.models.results

import com.finance.articles.domain.models.ArticleCategory

sealed class ObtainAllCategoriesResult {

    data object Error: ObtainAllCategoriesResult()

    data class Success(val categories: List<ArticleCategory>) : ObtainAllCategoriesResult()
}