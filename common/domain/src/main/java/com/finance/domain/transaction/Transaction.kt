package com.finance.domain.transaction

data class Transaction(
    val id: Int,
    val name: String,
    val emoji: String,
    val amount: String,
    val currency: String,
    val time: String,
    val comment: String? = null,
)