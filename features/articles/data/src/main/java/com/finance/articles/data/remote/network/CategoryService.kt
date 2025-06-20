package com.finance.articles.data.remote.network

import com.finance.articles.data.remote.models.CategoryModel
import com.finance.articles.data.remote.models.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CategoryService {

    @GET("categories")
    suspend fun getCategories(): Response<List<CategoryModel>>
}