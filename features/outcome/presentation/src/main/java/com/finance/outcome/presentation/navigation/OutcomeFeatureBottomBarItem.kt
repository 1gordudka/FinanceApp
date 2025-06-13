package com.finance.outcome.presentation.navigation

import com.finance.common.navigation.BottomBarItem
import com.finance.outcome.presentation.R

class OutcomeFeatureBottomBarItem : BottomBarItem {

    override val navigationRoute: String = OutcomeFeatureScreens.navigationRoute

    override val nameId: Int = R.string.outcome_route

    override val iconId: Int = R.drawable.outcome_ic
}
