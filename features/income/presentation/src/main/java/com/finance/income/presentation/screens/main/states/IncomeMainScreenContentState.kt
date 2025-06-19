package com.finance.income.presentation.screens.main.states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.finance.common.ui.components.GrayDivider
import com.finance.income.domain.models.AllIncome
import com.finance.income.domain.models.IncomeTransaction
import com.finance.income.presentation.screens.main.components.AmountCard
import com.finance.income.presentation.screens.main.components.CategoryCard
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenAction

@Composable
fun IncomeMainScreenContentState(
    categories: List<IncomeTransaction>,
    allIncome: AllIncome,
    onAction: (IncomeMainScreenAction) -> Unit
) {

    AmountCard(allIncome.formattedAmount, allIncome.currency)
    LazyColumn {
        item {
            GrayDivider()
        }
        items(categories, key = { it.id }) {
            CategoryCard(
                categoryName = it.categoryName,
                categoryAmount = it.formattedAmount,
                categoryCurrency = it.currency
            ) { }
            GrayDivider()
        }
    }
}