package com.finance.common.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun GrayDivider() {

    HorizontalDivider(
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth(),
        color = FinanceAppTheme.colors.lightGray
    )
}