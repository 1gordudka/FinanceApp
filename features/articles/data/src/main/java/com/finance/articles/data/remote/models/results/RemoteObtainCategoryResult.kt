package com.finance.articles.data.remote.models.results

import com.finance.articles.data.remote.models.CategoryResponse

sealed class RemoteObtainCategoryResult {

    data class Success(val response: CategoryResponse,) : RemoteObtainCategoryResult()

    data object Error: RemoteObtainCategoryResult()
}