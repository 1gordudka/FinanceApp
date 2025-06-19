package com.features.income.data.mock

import com.finance.income.domain.models.AllIncome
import com.finance.income.domain.models.IncomeTransaction

val allIncome = AllIncome(
    formattedAmount = "600 000",
    currency = "₽"
)

val allCategories = listOf(
    IncomeTransaction(
        id = 1,
        categoryName = "Зарплата",
        formattedAmount = "500 000",
        currency = "₽"
    ),
    IncomeTransaction(
        id = 2,
        categoryName = "Подработка",
        formattedAmount = "100 000",
        currency = "₽"
    )
)