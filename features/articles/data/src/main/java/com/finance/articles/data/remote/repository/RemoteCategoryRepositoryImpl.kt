package com.finance.articles.data.remote.repository

import com.finance.articles.data.remote.models.CategoryResponse
import com.finance.articles.data.remote.models.results.RemoteObtainCategoryResult
import com.finance.articles.data.remote.network.CategoryService
import kotlinx.coroutines.delay

class RemoteCategoryRepositoryImpl(
    private val categoryService: CategoryService
) : RemoteCategoryRepository {

    override suspend fun getCategories(): RemoteObtainCategoryResult {

        val maxRetries = 3
        val retryDelayMillis = 2000L

        repeat(maxRetries){attempt->
            try {
                val response = categoryService.getCategories()
                if (response.isSuccessful) {
                    return RemoteObtainCategoryResult.Success(CategoryResponse(response.body()!!))
                } else {
                    if (response.code() == 500){
                        if (attempt < maxRetries - 1) {
                            delay(retryDelayMillis)
                        }
                    }else{
                        return RemoteObtainCategoryResult.Error
                    }
                }
            }catch (e: Exception){
                return RemoteObtainCategoryResult.Error
            }
        }
        return RemoteObtainCategoryResult.Error
    }

}