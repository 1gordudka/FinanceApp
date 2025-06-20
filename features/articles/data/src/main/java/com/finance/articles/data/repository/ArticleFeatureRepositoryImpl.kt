package com.finance.articles.data.repository

import com.finance.articles.data.remote.models.mappers.toDomain
import com.finance.articles.data.remote.network.CategoryService
import com.finance.articles.data.remote.repository.RemoteCategoryRepository
import com.finance.articles.domain.models.repository.ArticleFeatureRepository
import com.finance.articles.domain.models.results.ObtainAllCategoriesResult

class ArticleFeatureRepositoryImpl(
    private val remoteCategoryRepository: RemoteCategoryRepository
) : ArticleFeatureRepository {
    override suspend fun getCategories(): ObtainAllCategoriesResult {
        return remoteCategoryRepository.getCategories().toDomain()
    }
}