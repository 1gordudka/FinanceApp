package com.finance.outcome.domain.models

sealed class OutcomeCategory{

    data class OutcomeCategoryLead(
        val categoryName: String,
        val formattedAmount: String,
        val currency: String,
        val emoji: String,
        val comment: String? = null,
    ) : OutcomeCategory()
}