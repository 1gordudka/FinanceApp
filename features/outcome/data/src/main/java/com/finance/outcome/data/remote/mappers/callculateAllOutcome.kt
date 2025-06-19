package com.finance.outcome.data.remote.mappers

import com.finance.domain.transaction.Transaction
import com.finance.outcome.data.remote.models.TransactionResponse
import com.finance.outcome.domain.models.AllOutcome

fun calculateAllOutcome(list: List<Transaction>): AllOutcome {

    val currency = list[0].account.currency
    var amount = 0.0

    list.forEach {
        if (!it.category.isIncome){
            amount += it.amount.toFloat()
        }
    }

    return AllOutcome(
        formattedAmount = amount.toString(),
        currency = currency
    )
}