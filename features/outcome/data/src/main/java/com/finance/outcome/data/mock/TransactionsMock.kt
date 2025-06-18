package com.finance.outcome.data.mock

import com.finance.domain.transaction.Transaction

val transactionsMockData = listOf(
    Transaction(
        id = 1,
        name = "Ремонт квартиры",
        emoji = "РК",
        amount = "100 000",
        currency = "₽",
        time = "22:01",
        comment = "Ремонт - фурнитура для дверей",
    ),
    Transaction(
        id = 2,
        name = "На собачку",
        emoji = "🐶",
        amount = "100 000",
        currency = "₽",
        time = "22:01",
        comment = null,
    ),
    Transaction(
        id = 3,
        name = "На собачку",
        emoji = "🐶",
        amount = "100 000",
        currency = "₽",
        time = "22:01",
        comment = null,
    )
)