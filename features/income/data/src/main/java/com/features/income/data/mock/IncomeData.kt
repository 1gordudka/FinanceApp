package com.features.income.data.mock

import com.finance.income.domain.models.AllIncome
import com.finance.income.domain.models.IncomeCategory

val allIncome = AllIncome(
    formattedAmount = "600 000",
    currency = "₽"
)

val allCategories = listOf(
    IncomeCategory(
        id = 1,
        categoryName = "Зарплата",
        formattedAmount = "500 000",
        currency = "₽"
    ),
    IncomeCategory(
        id = 2,
        categoryName = "Подработка",
        formattedAmount = "100 000",
        currency = "₽"
    )
)