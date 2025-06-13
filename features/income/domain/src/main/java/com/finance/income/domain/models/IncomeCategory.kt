package com.finance.income.domain.models

data class IncomeCategory(
    val id: Int,
    val categoryName: String,
    val formattedAmount: String,
    val currency: String,
)