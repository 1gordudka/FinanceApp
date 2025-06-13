package com.finance.outcome.data.mock

import com.finance.outcome.domain.models.AllOutcome
import com.finance.outcome.domain.models.OutcomeCategory

val allOutcome = AllOutcome(
    formattedAmount = "436 558",
    currency = "₽"
)

val allCategories = listOf(
    OutcomeCategory(
        id = 1,
        categoryName = "Аренда квартиры",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🏡"
    ),
    OutcomeCategory(
        id = 2,
        categoryName = "Одежда",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "👕"
    ),
    OutcomeCategory(
        id = 3,
        categoryName = "На собачку",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🐶",
        comment = "Джек"
    ),
    OutcomeCategory(
        id = 4,
        categoryName = "На собачку",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🐶",
        comment = "Энни"
    ),
    OutcomeCategory(
        id = 5,
        categoryName = "Ремонт квартиры",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "РК"
    ),
    OutcomeCategory(
        id = 6,
        categoryName = "Продукты",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🍭"
    ),
    OutcomeCategory(
        id = 7,
        categoryName = "Спортзал",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🏋️‍♂️"
    ),
    OutcomeCategory(
        id = 8,
        categoryName = "Медицина",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "💊"
    ),
)