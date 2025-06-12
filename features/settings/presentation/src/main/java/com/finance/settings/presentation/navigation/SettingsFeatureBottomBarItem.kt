package com.finance.settings.presentation.navigation

import com.finance.common.navigation.BottomBarItem
import com.finance.settings.presentation.R
import com.finance.settings.presentation.navigation.SettingsFeatureScreens

class SettingsFeatureBottomBarItem : BottomBarItem {

    override val navigationRoute: String = SettingsFeatureScreens.navigationRoute

    override val nameId: Int = R.string.settings_route

    override val iconId: Int = R.drawable.settings_ic
}
