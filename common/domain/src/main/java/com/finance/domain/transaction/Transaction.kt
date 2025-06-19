package com.finance.domain.transaction

data class Transaction(
    val id: Int,
    val account: Account,
    val category: Category,
    val amount: String,
    val transactionDate: String,
    val comment: String? = null,
    val createdAt: String,
    val updatedAt: String
)

data class Account(
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
