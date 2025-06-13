package com.features.income.data.remote.models

data class TransactionResponse(
    val id: Int,
    val account: AccountBrief,
    val category: Category,
    val amount: String,
    val transactionDate: String,
    val comment: String?, // nullable
    val createdAt: String,
    val updatedAt: String
)

data class AccountBrief(
    val id: Int,
    val name: String,
    val balance: String,
    val currency: String
)

data class Category(
    val id: Int,
    val name: String,
    val emoji: String,
    val isIncome: Boolean
)
