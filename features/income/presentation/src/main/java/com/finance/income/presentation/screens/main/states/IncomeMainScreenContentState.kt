package com.finance.income.presentation.screens.main.states

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.components.GrayDivider
import com.finance.common.ui.theme.FinanceAppTheme
import com.finance.income.domain.models.AllIncome
import com.finance.income.domain.models.IncomeCategoryListItem
import com.finance.income.presentation.R
import com.finance.income.presentation.screens.main.components.AmountCard
import com.finance.income.presentation.screens.main.components.CategoryCard
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenAction
import com.finance.income.presentation.screens.main.state_hoisting.IncomeMainScreenState

@Composable
fun IncomeMainScreenContentState(
    categories: List<IncomeCategoryListItem.IncomeCategoryLead>,
    allIncome: AllIncome,
    onAction: (IncomeMainScreenAction) -> Unit
) {

    AmountCard(allIncome.formattedAmount, allIncome.currency)
    LazyColumn {
        item {
            GrayDivider()
        }
        items(categories){
            CategoryCard(
                categoryName = it.categoryName,
                categoryAmount = it.formattedAmount,
                categoryCurrency = it.currency
            ) { }
            GrayDivider()
        }
    }
}