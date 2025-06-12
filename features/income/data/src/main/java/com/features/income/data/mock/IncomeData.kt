package com.features.income.data.mock

import com.finance.income.domain.models.AllIncome
import com.finance.income.domain.models.IncomeCategoryListItem

val allIncome = AllIncome(
    formattedAmount = "600 000",
    currency = "₽"
)

val allCategories = listOf(
    IncomeCategoryListItem.IncomeCategoryLead(
        categoryName = "Зарплата",
        formattedAmount = "500 000",
        currency = "₽"
    ),
    IncomeCategoryListItem.IncomeCategoryLead(
        categoryName = "Подработка",
        formattedAmount = "100 000",
        currency = "₽"
    )
)