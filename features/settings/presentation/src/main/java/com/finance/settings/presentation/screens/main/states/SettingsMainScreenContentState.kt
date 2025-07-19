package com.finance.settings.presentation.screens.main.states

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.finance.common.database.sync.SyncStatus
import com.finance.common.ui.components.GrayDivider
import com.finance.common.ui.components.SyncStatusIndicator
import com.finance.settings.domain.SettingsButton
import com.finance.settings.presentation.screens.main.components.SettingsButtonCard
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenAction

@Composable
fun SettingsMainScreenContentState(
    settings: List<SettingsButton>,
    syncStatus: SyncStatus,
    onAction: (SettingsMainScreenAction) -> Unit
) {

    LazyColumn {
        item {
            // Компонент статуса синхронизации
            SyncStatusIndicator(
                isOnline = syncStatus.isOnline,
                lastSyncTime = syncStatus.lastSyncTime,
                unsyncedItemsCount = syncStatus.unsyncedItemsCount,
                onSyncClick = { onAction(SettingsMainScreenAction.SyncClicked) },
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            GrayDivider()
        }
        
        items(settings) {
            SettingsButtonCard(it, onClick = {})
            GrayDivider()
        }
    }

}