package com.finance.settings.data.buttons

import com.finance.settings.domain.SettingsButton

val allSettingsButtons = listOf(
    SettingsButton.SettingsButtonSwitch(
        "Темная тема", false
    ),
    SettingsButton.SettingsButtonDefault(
        "Основной цвет"
    ),
    SettingsButton.SettingsButtonDefault(
        "Звуки"
    ),
    SettingsButton.SettingsButtonDefault(
        "Хаптики"
    ),
    SettingsButton.SettingsButtonDefault(
        "Код пароль"
    ),
    SettingsButton.SettingsButtonDefault(
        "Синхронизация"
    ),
    SettingsButton.SettingsButtonDefault(
        "Язык"
    ),
    SettingsButton.SettingsButtonDefault(
        "О программе"
    )
)