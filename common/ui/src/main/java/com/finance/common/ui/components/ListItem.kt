package com.finance.common.ui.components

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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun ListItem(
    lead: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
    trail: (@Composable () -> Unit)? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier
        .fillMaxWidth()
        .background(FinanceAppTheme.colors.background)
        .clickable {
            onClick()
        }
        .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        if (lead != null) {
            lead()
            Spacer(Modifier.width(16.dp))
        }
        content()
        Spacer(Modifier.weight(1f))
        if (trail != null) {
            trail()
        }
    }
}