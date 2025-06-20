package com.finance.articles.domain.models.use_cases

import com.finance.articles.domain.models.repository.ArticleFeatureRepository

class GetCategoriesUseCase(
    private var articleFeatureRepository: ArticleFeatureRepository
) {

    suspend operator fun invoke() = articleFeatureRepository.getCategories()
}