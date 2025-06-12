package com.finance.breef.presentation.navigation

import com.finance.breef.presentation.R
import com.finance.common.navigation.BottomBarItem
import com.finance.breef.presentation.navigation.BreefFeatureScreens

class BreefFeatureBottomBarItem : BottomBarItem {

    override val navigationRoute: String = BreefFeatureScreens.navigationRoute

    override val nameId: Int = R.string.breef_route

    override val iconId: Int = R.drawable.breef_ic
}
