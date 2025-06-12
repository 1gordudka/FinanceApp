package com.finance.outcome.presentation.screens.main.states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.GrayDivider
import com.finance.outcome.domain.models.AllOutcome
import com.finance.outcome.domain.models.OutcomeCategory
import com.finance.outcome.presentation.screens.main.components.AmountCard
import com.finance.outcome.presentation.screens.main.components.CategoryCard
import com.finance.outcome.presentation.screens.main.state_hoisting.OutcomeMainScreenAction

@Composable
fun OutcomeMainScreenContentState(
    categories: List<OutcomeCategory.OutcomeCategoryLead>,
    allOutcome: AllOutcome,
    onAction: (OutcomeMainScreenAction) -> Unit
) {

    AmountCard(allOutcome.formattedAmount, allOutcome.currency)
    LazyColumn {
        item {
            GrayDivider()
        }
        items(categories) {
            CategoryCard(
                categoryName = it.categoryName,
                categoryAmount = it.formattedAmount,
                categoryCurrency = it.currency,
                emoji = it.emoji,
                comment = it.comment
            ) { }
            GrayDivider()
        }
    }

}