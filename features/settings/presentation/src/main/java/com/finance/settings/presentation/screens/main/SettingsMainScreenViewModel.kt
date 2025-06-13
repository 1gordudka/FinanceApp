package com.finance.settings.presentation.screens.main

import androidx.lifecycle.viewModelScope
import com.finance.common.ui.state_hoisting.StatefulViewModel
import com.finance.settings.data.buttons.allSettingsButtons
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenAction
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenEffect
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn

class SettingsMainScreenViewModel() :
    StatefulViewModel<SettingsMainScreenState, SettingsMainScreenEffect, SettingsMainScreenAction>() {

    val state = _state.receiveAsFlow().stateIn(
        viewModelScope, SharingStarted.Eagerly, SettingsMainScreenState.Content(
            settings = allSettingsButtons
        )
    )

    override fun onAction(action: SettingsMainScreenAction) {
        // handle settings actions here
    }
}
