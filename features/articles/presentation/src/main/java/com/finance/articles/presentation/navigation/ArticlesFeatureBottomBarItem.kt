package com.finance.articles.presentation.navigation

import com.finance.articles.presentation.R
import com.finance.common.navigation.BottomBarItem
import com.finance.articles.presentation.navigation.ArticlesFeatureScreens
class ArticlesFeatureBottomBarItem : BottomBarItem {

    override val navigationRoute: String = ArticlesFeatureScreens.navigationRoute

    override val nameId: Int = R.string.articles_route

    override val iconId: Int = R.drawable.articles_ic
}
