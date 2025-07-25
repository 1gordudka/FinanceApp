package com.finance.settings.data.buttons

import com.finance.settings.domain.SettingsButton

val allSettingsButtons = listOf(
    SettingsButton.SettingsButtonSwitch(
        "Темная тема", false, "theme"
    ),
    SettingsButton.SettingsButtonDefault(
        "Основной цвет", "primary_color_screen"
    ),
    SettingsButton.SettingsButtonDefault(
        "Хаптики", "haptics_screen"
    ),
    SettingsButton.SettingsButtonDefault(
        "Код пароль", "pin_code_setup_screen"
    ),
    SettingsButton.SettingsButtonDefault(
        "Синхронизация", "sync_frequency_screen"
    ),
    SettingsButton.SettingsButtonDefault(
        "Язык", "language_screen"
    ),
    SettingsButton.SettingsButtonDefault(
        "О программе", "app_info_screen"
    )
)