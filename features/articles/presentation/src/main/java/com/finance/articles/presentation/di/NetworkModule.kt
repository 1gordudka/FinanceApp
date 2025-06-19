package com.finance.articles.presentation.di

import com.finance.articles.data.remote.network.CategoryService
import com.finance.common.network.utils.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {


    @ArticlesFeatureComponentScope
    @Provides
    fun providesCategoriesService(retrofit: Retrofit): CategoryService =
        retrofit.create(CategoryService::class.java)

}