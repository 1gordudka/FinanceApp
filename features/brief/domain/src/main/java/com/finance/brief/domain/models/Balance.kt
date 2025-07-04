package com.finance.brief.domain.models

data class Balance(
    val name: String,
    val formattedAmount: String,
    val currency: String,
)