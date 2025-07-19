package com.finance.settings.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.common.database.sync.SyncStatusManager
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.settings.data.buttons.allSettingsButtons
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenAction
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenEffect
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsMainScreenViewModel @Inject constructor(
    private val syncStatusManager: SyncStatusManager
) : StatefulViewModel<SettingsMainScreenState, SettingsMainScreenEffect, SettingsMainScreenAction>() {

    val state = combine(
        _state.receiveAsFlow(),
        syncStatusManager.syncStatus
    ) { screenState, syncStatus ->
        SettingsMainScreenState.Content(
            settings = allSettingsButtons,
            syncStatus = syncStatus
        )
    }.stateIn(
        viewModelScope, SharingStarted.Eagerly, SettingsMainScreenState.Content(
            settings = allSettingsButtons,
            syncStatus = com.finance.common.database.sync.SyncStatus()
        )
    )

    init {
        // Обновляем статус синхронизации при запуске
        viewModelScope.launch {
            syncStatusManager.updateSyncStatus()
        }
    }

    override fun onAction(action: SettingsMainScreenAction) {
        when (action) {
            is SettingsMainScreenAction.SyncClicked -> {
                viewModelScope.launch {
                    syncStatusManager.performManualSync()
                }
            }
        }
    }
}
