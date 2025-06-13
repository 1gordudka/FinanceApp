package com.features.income.data.remote.mappers

import com.features.income.data.remote.models.TransactionResponse
import com.finance.income.domain.models.AllIncome


fun calculateAllIncome(list: List<TransactionResponse>): AllIncome {

    val currency = list[0].account.currency
    var amount = 0.0

    list.forEach {
        if (it.category.isIncome) {
            amount += it.amount.toFloat()
        }

    }

    return AllIncome(
        formattedAmount = amount.toString(),
        currency = currency
    )
}