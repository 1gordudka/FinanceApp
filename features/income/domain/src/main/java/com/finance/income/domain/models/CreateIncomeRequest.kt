package com.finance.income.domain.models

data class CreateIncomeRequest(
    val amount: String,
    val categoryId: Int,
    val accountId: Int,
    val comment: String? = null,
    val transactionDate: String
) 