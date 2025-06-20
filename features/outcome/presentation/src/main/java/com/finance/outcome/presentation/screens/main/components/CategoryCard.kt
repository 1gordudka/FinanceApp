package com.finance.outcome.presentation.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.sp
import com.finance.common.ui.components.ListItem
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun CategoryCard(
    emoji: String,
    categoryName: String,
    categoryAmount: String,
    categoryCurrency: String,
    comment: String?,
    onClick: () -> Unit
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
                Text(categoryName, style = MaterialTheme.typography.bodyLarge)
                comment.let { com ->
                    if (com != null) {
                        Text(com, style = MaterialTheme.typography.bodyMedium)
                    }
                }

            }
        },
        trail = {
            Text(
                "$categoryAmount $categoryCurrency",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(end = 16.dp)
            )
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