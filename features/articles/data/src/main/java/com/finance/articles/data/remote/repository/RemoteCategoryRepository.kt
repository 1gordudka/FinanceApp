package com.finance.articles.data.remote.repository

import com.finance.articles.data.remote.models.results.RemoteObtainCategoryResult

interface RemoteCategoryRepository {

    suspend fun getCategories() : RemoteObtainCategoryResult
}