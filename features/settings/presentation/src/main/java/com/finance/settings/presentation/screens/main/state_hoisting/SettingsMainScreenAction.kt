package com.finance.settings.presentation.screens.main.state_hoisting

sealed class SettingsMainScreenAction {
    
    data object SyncClicked : SettingsMainScreenAction()
}