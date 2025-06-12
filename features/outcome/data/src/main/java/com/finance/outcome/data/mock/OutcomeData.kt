package com.finance.outcome.data.mock

import com.finance.outcome.domain.models.AllOutcome
import com.finance.outcome.domain.models.OutcomeCategory

val allOutcome = AllOutcome(
    formattedAmount = "436 558",
    currency = "₽"
)

val allCategories = listOf(
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "Аренда квартиры",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🏡"
    ),
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "Одежда",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "👕"
    ),
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "На собачку",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🐶",
        comment = "Джек"
    ),
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "На собачку",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🐶",
        comment = "Энни"
    ),
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "Ремонт квартиры",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "РК"
    ),
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "Продукты",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🍭"
    ),
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "Спортзал",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "🏋️‍♂️"
    ),
    OutcomeCategory.OutcomeCategoryLead(
        categoryName = "Медицина",
        formattedAmount = "100 000",
        currency = "₽",
        emoji = "💊"
    ),
)