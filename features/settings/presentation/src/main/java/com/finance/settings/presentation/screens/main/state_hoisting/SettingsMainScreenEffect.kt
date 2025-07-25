package com.finance.settings.presentation.screens.main.state_hoisting

sealed class SettingsMainScreenEffect {
    data class NavigateToSetting(val route: String) : SettingsMainScreenEffect()
}