package com.finance.settings.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.settings.data.buttons.allSettingsButtons
import com.finance.settings.domain.usecase.SettingsUseCases
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
    private val settingsUseCases: SettingsUseCases
) : StatefulViewModel<SettingsMainScreenState, SettingsMainScreenEffect, SettingsMainScreenAction>() {

    val state = combine(
        _state.receiveAsFlow(),
        settingsUseCases.getDarkTheme()
    ) { screenState, isDarkTheme ->
        SettingsMainScreenState.Content(
            settings = allSettingsButtons.map { button ->
                if (button is com.finance.settings.domain.SettingsButton.SettingsButtonSwitch && button.route == "theme") {
                    button.copy(enabled = isDarkTheme)
                } else {
                    button
                }
            }
        )
    }.stateIn(
        viewModelScope, SharingStarted.Eagerly, SettingsMainScreenState.Content(
            settings = allSettingsButtons
        )
    )

    override fun onAction(action: SettingsMainScreenAction) {
        when (action) {
            is SettingsMainScreenAction.SyncClicked -> {
                // Handle sync action if needed
            }
            is SettingsMainScreenAction.SettingClicked -> {
                viewModelScope.launch {
                    updateEffect(SettingsMainScreenEffect.NavigateToSetting(action.route))
                }
            }
            is SettingsMainScreenAction.ThemeToggled -> {
                viewModelScope.launch {
                    settingsUseCases.setDarkTheme(action.isDark)
                    settingsUseCases.performTabHaptic()
                }
            }
        }
    }
}
