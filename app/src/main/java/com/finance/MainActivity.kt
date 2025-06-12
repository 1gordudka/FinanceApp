package com.finance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.theme.FinanceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val navigationComponent = appComponent.navigationComponentFactory.create()

        val order = listOf(
            "outcome_feature_navigation_route",
            "income_feature_navigation_route",
            "breef_feature_navigation_route",
            "articles_feature_navigation_route",
            "settings_feature_navigation_route"
        )

        setContent {

            AppContent(
                bottomBarItems = navigationComponent.bottomBarItems.toList().sortedBy { order.indexOf(it.navigationRoute) },
                featureNavigationApis = navigationComponent.featureNavigationApi.toList().sortedBy { order.indexOf(it.navigationRoute) }
            )
        }
    }
}