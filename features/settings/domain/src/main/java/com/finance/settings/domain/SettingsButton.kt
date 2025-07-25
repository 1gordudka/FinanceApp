package com.finance.settings.domain

sealed class SettingsButton {

    data class SettingsButtonSwitch(
        val name: String,
        val enabled: Boolean,
        val route: String? = null
    ): SettingsButton()

    data class SettingsButtonDefault(
        val name: String,
        val route: String
    ): SettingsButton()
}