package com.finance.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.sp
import com.finance.common.ui.ext.formatIsoDate
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun TransactionCard(
    name: String,
    amount: String,
    currency: String,
    time: String,
    emoji: String,
    comment: String? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    ListItem(
        lead = {
            Box(
                Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(FinanceAppTheme.colors.lightPrimary)
            ) {
                Text(
                    emoji, modifier = Modifier.align(
                        Alignment.Center
                    ), fontSize = 12.sp, color = Color.Black
                )
            }
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(name, style = MaterialTheme.typography.bodyLarge)
                comment.let { com ->
                    if (com != null) {
                        Text(com, style = MaterialTheme.typography.labelMedium)
                    }
                }

            }
        },
        trail = {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    "$amount $currency",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(end = 16.dp)
                )
                Text(
                    formatIsoDate(time),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
            IconButton(onClick, modifier = Modifier.size(24.dp)) {
                Icon(
                    Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    "",
                    tint = FinanceAppTheme.colors.lightGray
                )
            }
        },
        onClick = onClick,
        modifier = Modifier.height(70.dp)
    )
}