package com.finance.brief.presentation.screens.create.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun GreenTextField(
    placeholder: String,
    text: String,
    onChange: (String) -> Unit,
    isDigit: Boolean = false,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        text, { onChange(it) },
        placeholder = {
            Text(placeholder)
        }, modifier = modifier,
        enabled = enabled,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFD4FAE6),
            unfocusedContainerColor = Color(0xFFD4FAE6),
            unfocusedBorderColor = Color.White.copy(alpha = 0f),
            focusedBorderColor = Color.White.copy(0f),
            disabledContainerColor = Color(0xFFD4FAE6),
            disabledTextColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isDigit) KeyboardType.Number else KeyboardType.Text
        )
    )

}