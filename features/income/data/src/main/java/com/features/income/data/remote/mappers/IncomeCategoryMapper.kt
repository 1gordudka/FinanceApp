package com.features.income.data.remote.mappers

import com.features.income.data.remote.models.TransactionResponse
import com.finance.income.domain.models.IncomeCategory

fun incomeCategoryToUIMapper(list: List<TransactionResponse>): List<IncomeCategory> {
    return list
        .filter { it.category.isIncome }
        .groupBy { it.category.id }
        .map { (_, transactions) ->
            val first = transactions.first()
            val totalAmount = transactions.sumOf { it.amount.toDoubleOrNull() ?: 0.0 }
            IncomeCategory(
                id = first.category.id,
                categoryName = first.category.name,
                formattedAmount = String.format("%,.2f", totalAmount).replace(',', ' '),
                currency = first.account.currency
            )
        }
}
