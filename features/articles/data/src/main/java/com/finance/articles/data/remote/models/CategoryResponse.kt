package com.finance.articles.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CategoryResponse(
    val categories: List<CategoryModel>,
)

data class CategoryModel(
    val id: Int,
    val name: String,
    val emoji: String,
    val isIncome: Boolean,
)