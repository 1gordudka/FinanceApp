package com.finance.settings.presentation.screens.main.states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.finance.common.ui.components.GrayDivider
import com.finance.settings.domain.SettingsButton
import com.finance.settings.presentation.screens.main.components.SettingsButtonCard
import com.finance.settings.presentation.screens.main.state_hoisting.SettingsMainScreenAction

@Composable
fun SettingsMainScreenContentState(
    settings: List<SettingsButton>,
    onAction: (SettingsMainScreenAction) -> Unit
) {

    LazyColumn {
        items(settings) { settingButton ->
            SettingsButtonCard(
                settingsButton = settingButton, 
                onClick = {
                    when (settingButton) {
                        is SettingsButton.SettingsButtonDefault -> {
                            onAction(SettingsMainScreenAction.SettingClicked(settingButton.route))
                        }
                        is SettingsButton.SettingsButtonSwitch -> {
                            if (settingButton.route == "theme") {
                                onAction(SettingsMainScreenAction.ThemeToggled(!settingButton.enabled))
                            }
                        }
                    }
                },
                onSwitchToggle = { isChecked ->
                    if (settingButton is SettingsButton.SettingsButtonSwitch && settingButton.route == "theme") {
                        onAction(SettingsMainScreenAction.ThemeToggled(isChecked))
                    }
                }
            )
            GrayDivider()
        }
    }

}