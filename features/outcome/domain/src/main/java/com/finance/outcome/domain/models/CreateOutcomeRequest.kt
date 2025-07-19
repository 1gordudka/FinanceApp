package com.finance.outcome.domain.models

data class CreateOutcomeRequest(
    val amount: String,
    val categoryId: Int,
    val accountId: Int,
    val comment: String? = null,
    val transactionDate: String
) 