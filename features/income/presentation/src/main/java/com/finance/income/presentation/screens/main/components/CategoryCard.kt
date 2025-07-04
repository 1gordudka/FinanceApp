package com.finance.income.presentation.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.common.ui.components.ListItem
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun CategoryCard(
    categoryName: String,
    categoryAmount: String,
    categoryCurrency: String,
    onClick: () -> Unit
) {

    ListItem(
        content = {
            Text(categoryName, style = MaterialTheme.typography.bodyLarge)
        },
        trail = {
            Text("$categoryAmount $categoryCurrency", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(end = 16.dp))
            IconButton(onClick, modifier = Modifier.size(24.dp)) {
                Icon(Icons.AutoMirrored.Rounded.KeyboardArrowRight, "", tint = FinanceAppTheme.colors.lightGray)
            }
        },
        onClick = onClick,
        modifier = Modifier.height(70.dp)
    )

}