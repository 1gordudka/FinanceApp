package com.finance.outcome.data.remote.mappers

import com.finance.domain.transaction.Transaction
import com.finance.outcome.domain.models.OutcomeCategory

fun incomeCategoryToUIMapper(list: List<Transaction>): List<OutcomeCategory> {
    return list
        .filter { !it.category.isIncome }
        .groupBy { it.category.id }
        .map { (_, transactions) ->
            val latestTransaction = transactions.maxByOrNull { it.createdAt } ?: transactions.first()
            val totalAmount = transactions.sumOf { it.amount.toDoubleOrNull() ?: 0.0 }
            OutcomeCategory(
                id = latestTransaction.id, // ID последней транзакции для навигации к редактированию
                categoryName = latestTransaction.category.name,
                formattedAmount = String.format("%,.2f", totalAmount).replace(',', ' '),
                currency = latestTransaction.account.currency,
                emoji = latestTransaction.category.emoji
            )
        }
}