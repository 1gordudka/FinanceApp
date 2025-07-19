package com.finance.income.presentation.screens.add_income.states

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.finance.common.ui.components.GrayDivider
import com.finance.common.ui.components.GreenTextField
import com.finance.income.presentation.screens.add_income.components.DatePickerField

@Composable
fun AddIncomeScreenContentState(
    amount: String,
    categoryId: String,
    comment: String,
    accountId: String,
    date: String,
    changeAmount: (String) -> Unit,
    changeCategoryId: (String) -> Unit,
    changeComment: (String) -> Unit,
    changeAccountId: (String) -> Unit,
    changeDate: (String) -> Unit
) {
    GreenTextField(
        placeholder = "Счет (ID)",
        text = accountId,
        onChange = { changeAccountId(it) },
        isDigit = true,
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()

    GreenTextField(
        placeholder = "Статья (ID)",
        text = categoryId,
        onChange = { changeCategoryId(it) },
        isDigit = true,
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()

    GreenTextField(
        placeholder = "Сумма",
        text = amount,
        onChange = { changeAmount(it) },
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()

    DatePickerField(
        selectedDate = date,
        onDateSelected = { changeDate(it) },
        modifier = Modifier.fillMaxWidth()
    )

    GrayDivider()

    GreenTextField(
        placeholder = "Комментарий",
        text = comment,
        onChange = { changeComment(it) },
        modifier = Modifier.fillMaxWidth()
    )

} 