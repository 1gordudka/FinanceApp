package com.finance.settings.presentation.screens.main.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.finance.common.ui.components.ListItem
import com.finance.settings.domain.SettingsButton
import com.finance.settings.presentation.R

@Composable
fun SettingsButtonCard(
    settingsButton: SettingsButton,
    onClick: () -> Unit,
    onSwitchToggle: ((Boolean) -> Unit)? = null
) {

    ListItem(
        content = {
            when (settingsButton) {
                is SettingsButton.SettingsButtonDefault -> {
                    Text(
                        settingsButton.name, style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .padding(vertical = 16.dp)
                    )
                }

                is SettingsButton.SettingsButtonSwitch -> {
                    Text(
                        settingsButton.name, style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .padding(vertical = 16.dp)
                    )
                }
            }
        },
        trail = {
            when (settingsButton) {
                is SettingsButton.SettingsButtonDefault -> {
                    IconButton(onClick, Modifier.size(24.dp)) {
                        Icon(painterResource(R.drawable.right_arrow), "")
                    }
                }

                is SettingsButton.SettingsButtonSwitch -> {
                    Switch(
                        checked = settingsButton.enabled, 
                        onCheckedChange = { checked ->
                            onSwitchToggle?.invoke(checked)
                        }
                    )
                }
            }
        },
        onClick = {
            when (settingsButton) {
                is SettingsButton.SettingsButtonDefault -> onClick()
                is SettingsButton.SettingsButtonSwitch -> {
                    onSwitchToggle?.invoke(!settingsButton.enabled)
                }
            }
        },
        modifier = Modifier.height(56.dp)
    )


}