package com.finance

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.finance.common.network.utils.isInternetAvailable
import com.finance.common.ui.components.FeatureTopBar
import com.finance.common.ui.theme.FinanceAppTheme
import com.finance.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val navigationComponent = appComponent.navigationComponentFactory.create()

        val order = listOf(
            "outcome_feature_navigation_route",
            "income_feature_navigation_route",
            "brief_feature_navigation_route",
            "articles_feature_navigation_route",
            "settings_feature_navigation_route"
        )

        setContent {

            val context = LocalContext.current

            LaunchedEffect(true) {
                if (!context.isInternetAvailable()){
                    Toast.makeText(context, "Нет интернета!", Toast.LENGTH_SHORT).show()
                }
            }

            AppContent(
                bottomBarItems = navigationComponent.bottomBarItems.toList().sortedBy { order.indexOf(it.navigationRoute) },
                featureNavigationApis = navigationComponent.featureNavigationApi.toList().sortedBy { order.indexOf(it.navigationRoute) }
            )
        }
    }
}