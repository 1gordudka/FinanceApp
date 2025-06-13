package com.finance.settings.domain

sealed class SettingsButton {

    data class SettingsButtonSwitch(
        val name: String,
        val enabled: Boolean,
    ): SettingsButton()

    data class SettingsButtonDefault(
        val name: String,
    ): SettingsButton()
}