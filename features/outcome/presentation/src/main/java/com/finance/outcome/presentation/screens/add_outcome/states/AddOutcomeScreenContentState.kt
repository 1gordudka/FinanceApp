package com.finance.outcome.presentation.screens.add_outcome.states

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.GrayDivider
import com.finance.common.ui.components.GreenTextField
import com.finance.outcome.presentation.screens.add_outcome.components.DatePickerField
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenAction
import com.finance.outcome.presentation.screens.add_outcome.state_hoisting.AddOutcomeScreenState

@Composable
fun AddOutcomeScreenContentState(
    state: AddOutcomeScreenState.Content,
    onAction: (AddOutcomeScreenAction) -> Unit
) {
    GreenTextField(
        placeholder = "Счет (ID)",
        text = state.accountId,
        onChange = { onAction(AddOutcomeScreenAction.OnAccountIdChange(it)) },
        isDigit = true,
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()

    GreenTextField(
        placeholder = "Статья (ID)",
        text = state.categoryId,
        onChange = { onAction(AddOutcomeScreenAction.OnCategoryIdChange(it)) },
        isDigit = true,
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()

    GreenTextField(
        placeholder = "Сумма",
        text = state.amount,
        onChange = { onAction(AddOutcomeScreenAction.OnAmountChange(it)) },
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()

    DatePickerField(
        value = state.date,
        onValueChange = { onAction(AddOutcomeScreenAction.OnDateChange(it)) },
        label = "Дата",
        modifier = Modifier.fillMaxWidth()
    )

    GrayDivider()

    GreenTextField(
        placeholder = "Комментарий",
        text = state.comment,
        onChange = { onAction(AddOutcomeScreenAction.OnCommentChange(it)) },
        modifier = Modifier.fillMaxWidth()
    )
} 