package com.finance.brief.presentation.screens.create.states

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.brief.presentation.screens.create.components.GreenTextField
import com.finance.common.ui.components.GrayDivider

@Composable
fun CreateAccountScreenContentState(
    name: String,
    amount: String,
    currency: String,
    changeName: (String) -> Unit,
    changeAmount: (String) -> Unit,
    changeCurrency: (String) -> Unit
 ) {
    
    
    GreenTextField(
        placeholder = "Название счета",
        text = name,
        onChange = {changeName(it)},
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()
    GreenTextField(
        placeholder = "Баланс",
        text = amount,
        onChange = {changeAmount(it)},
        isDigit = true,
        modifier = Modifier.fillMaxWidth()
    )
    GrayDivider()
    GreenTextField(
        placeholder = "Валюта",
        text = currency,
        onChange = {changeCurrency(it)},
        modifier = Modifier.fillMaxWidth()
    )
    
}