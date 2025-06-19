package com.finance.articles.data.remote.models.mappers

import com.finance.articles.data.remote.models.CategoryModel
import com.finance.articles.data.remote.models.CategoryResponse
import com.finance.articles.data.remote.models.results.RemoteObtainCategoryResult
import com.finance.articles.domain.models.ArticleCategory
import com.finance.articles.domain.models.results.ObtainAllCategoriesResult

fun RemoteObtainCategoryResult.toDomain() = when (this) {
    RemoteObtainCategoryResult.Error -> ObtainAllCategoriesResult.Error
    is RemoteObtainCategoryResult.Success -> ObtainAllCategoriesResult.Success(
        categories = this.response.categories.map { it.toDomain() }
    )
}

fun CategoryModel.toDomain() =
    ArticleCategory(
        id = this.id,
        emoji = this.emoji,
        name = this.name
    )