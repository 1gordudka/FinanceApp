package com.features.income.data.remote.mappers

import com.finance.domain.transaction.Transaction
import com.finance.income.domain.models.IncomeTransaction

fun incomeCategoryToUIMapper(list: List<Transaction>): List<IncomeTransaction> {
    return list
        .filter { it.category.isIncome }
        .groupBy { it.category.id }
        .map { (_, transactions) ->
            val first = transactions.first()
            val totalAmount = transactions.sumOf { it.amount.toDoubleOrNull() ?: 0.0 }
            IncomeTransaction(
                id = first.category.id,
                categoryName = first.category.name,
                formattedAmount = String.format("%,.2f", totalAmount).replace(',', ' '),
                currency = first.account.currency
            )
        }
}
