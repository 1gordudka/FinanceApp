package com.finance.outcome.domain.models

data class OutcomeCategory(
    val id: Int,
    val categoryName: String,
    val formattedAmount: String,
    val currency: String,
    val emoji: String,
    val comment: String? = null,
)