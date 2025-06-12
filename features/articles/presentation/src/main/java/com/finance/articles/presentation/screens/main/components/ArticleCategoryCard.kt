package com.finance.articles.presentation.screens.main.components

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
fun ArticleCategoryCard(
    name: String,
    emoji: String,
    onClick: () -> Unit
) {

    Row(
        Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(FinanceAppTheme.colors.background)
            .clickable { onClick() }
            .padding(vertical = 22.dp, horizontal = 16.dp)
    ) {
        Box(Modifier.size(24.dp).clip(CircleShape).background(FinanceAppTheme.colors.lightPrimary)){
            Text(emoji, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.align(
                Alignment.Center))
        }
        Spacer(Modifier.width(16.dp))
        Text(name, style = MaterialTheme.typography.bodyLarge)
    }

}