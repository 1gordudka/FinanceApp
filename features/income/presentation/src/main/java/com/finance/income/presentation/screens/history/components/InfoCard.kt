package com.finance.income.presentation.screens.history.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun InfoCard(
    type: String,
    info: String
) {

    Row (
        Modifier
            .fillMaxWidth()
            .background(FinanceAppTheme.colors.lightPrimary)
            .height(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically){
        Text(type, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(end = 16.dp))
        Spacer(Modifier.weight(1f))
        Text(info, style = MaterialTheme.typography.bodyLarge)
    }
}