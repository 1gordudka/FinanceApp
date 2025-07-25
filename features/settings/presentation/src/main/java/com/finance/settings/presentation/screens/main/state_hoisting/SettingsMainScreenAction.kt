package com.finance.settings.presentation.screens.main.state_hoisting

sealed class SettingsMainScreenAction {
    data object SyncClicked : SettingsMainScreenAction()
    data class SettingClicked(val route: String) : SettingsMainScreenAction()
    data class ThemeToggled(val isDark: Boolean) : SettingsMainScreenAction()
}