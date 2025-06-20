package com.finance.outcome.data.remote.mappers

import com.finance.domain.transaction.Transaction
import com.finance.outcome.data.remote.models.TransactionResponse
import com.finance.outcome.domain.models.OutcomeCategory

fun incomeCategoryToUIMapper(list: List<Transaction>): List<OutcomeCategory> {
    return list
        .filter { !it.category.isIncome }
        .groupBy { it.category.id }
        .map { (_, transactions) ->
            val first = transactions.first()
            val totalAmount = transactions.sumOf { it.amount.toDoubleOrNull() ?: 0.0 }
            OutcomeCategory(
                id = first.category.id,
                categoryName = first.category.name,
                formattedAmount = String.format("%,.2f", totalAmount).replace(',', ' '),
                currency = first.account.currency,
                emoji = first.category.emoji
            )
        }
}