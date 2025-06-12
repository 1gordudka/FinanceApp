package com.finance.income.presentation.navigation

import com.finance.common.navigation.BottomBarItem
import com.finance.income.presentation.R

class IncomeFeatureBottomBarItem(

) : BottomBarItem {

    override val navigationRoute: String = IncomeFeatureScreens.navigationRoute

    override val nameId: Int = R.string.route

    override val iconId: Int = R.drawable.income_ic
}