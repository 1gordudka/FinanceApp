package com.finance.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.finance.common.ui.theme.FinanceAppTheme

@Composable
fun FeatureTopBar(
    featureNameId: Int? = null,
    name: String? = null,
    actionButton: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {


    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(FinanceAppTheme.colors.primary)
    ) {
        Text(
            text = if (featureNameId == null) name!! else stringResource(featureNameId),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 18.dp),
            style = MaterialTheme.typography.titleLarge
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(horizontal = 4.dp, vertical = 8.dp)
        ) {
            actionButton()
        }
    }
}