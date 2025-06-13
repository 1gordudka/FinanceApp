package com.finance.brief.presentation.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun BalanceCard(
    amount: String,
    currency: String,
    onClick: () -> Unit
) {

    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(FinanceAppTheme.colors.lightPrimary)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(Modifier.size(24.dp).clip(CircleShape).background(Color.White)){
            Text("💰", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.align(
                Alignment.Center))
        }
        Spacer(Modifier.width(16.dp))
        Text("Баланс", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.weight(1f))
        Text("$amount $currency", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.width(16.dp))
        IconButton(onClick, modifier = Modifier.size(24.dp)) {
            Icon(Icons.AutoMirrored.Rounded.KeyboardArrowRight, "", tint = FinanceAppTheme.colors.lightGray)
        }
    }

}