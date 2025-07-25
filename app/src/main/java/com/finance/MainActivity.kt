package com.finance

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.finance.articles.presentation.navigation.ArticlesFeatureScreens
import com.finance.brief.presentation.navigation.BriefFeatureScreens
import com.finance.common.network.utils.isInternetAvailable
import com.finance.income.presentation.navigation.IncomeFeatureScreens
import com.finance.outcome.presentation.navigation.OutcomeFeatureScreens
import com.finance.settings.presentation.navigation.SettingsFeatureScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val navigationComponent = appComponent.navigationComponentFactory.create()

        val order = listOf(
            OutcomeFeatureScreens.navigationRoute,
            IncomeFeatureScreens.navigationRoute,
            BriefFeatureScreens.navigationRoute,
            ArticlesFeatureScreens.navigationRoute,
            SettingsFeatureScreens.navigationRoute
        )

        setContent {

            val context = LocalContext.current

            LaunchedEffect(true) {
                if (!context.isInternetAvailable()) {
                    Toast.makeText(context, "Нет интернета!", Toast.LENGTH_SHORT).show()
                }
            }

            AppContent(
                bottomBarItems = navigationComponent.bottomBarItems.toList()
                    .sortedBy { order.indexOf(it.navigationRoute) },
                featureNavigationApis = navigationComponent.featureNavigationApi.toList()
                    .sortedBy { order.indexOf(it.navigationRoute) },
                settingsUseCases = appComponent.settingsComponentFactory.create().settingsUseCases
            )
        }
    }
}