package com.finance.brief.presentation.navigation

import com.finance.brief.presentation.R
import com.finance.common.navigation.BottomBarItem

class BriefFeatureBottomBarItem : BottomBarItem {

    override val navigationRoute: String = BriefFeatureScreens.navigationRoute

    override val nameId: Int = R.string.brief_route

    override val iconId: Int = R.drawable.breef_ic
}
