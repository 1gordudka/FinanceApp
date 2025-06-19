package com.finance.brief.presentation.screens.create.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.TextAutoSizeDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun GreenTextField(
    placeholder: String,
    text: String,
    onChange: (String) -> Unit,
    isDigit: Boolean = false,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        text, { onChange(it) },
        placeholder = {
            Text(placeholder)
        }, modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFD4FAE6),
            unfocusedContainerColor = Color(0xFFD4FAE6),
            unfocusedBorderColor = Color.White.copy(alpha = 0f),
            focusedBorderColor = Color.White.copy(0f)
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isDigit) KeyboardType.Number else KeyboardType.Text
        )
    )

}