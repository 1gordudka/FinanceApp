package com.finance.settings.presentation.screens.main.state_hoisting

import com.finance.settings.domain.SettingsButton

sealed class SettingsMainScreenState {

    data class Content(
        val settings: List<SettingsButton>
    ) : SettingsMainScreenState()

    data object Loading : SettingsMainScreenState()

    data object Empty : SettingsMainScreenState()

    data object Error : SettingsMainScreenState()
}
