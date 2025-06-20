package com.finance.articles.domain.models.repository

import com.finance.articles.domain.models.ArticleCategory
import com.finance.articles.domain.models.results.ObtainAllCategoriesResult

interface ArticleFeatureRepository {

    suspend fun getCategories(): ObtainAllCategoriesResult
}