package com.finance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.finance.brief.presentation.navigation.BriefFeatureScreens
import com.finance.common.navigation.BottomBarItem
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.ui.theme.FinanceAppTheme
import com.finance.income.presentation.navigation.IncomeFeatureScreens
import com.finance.navigation.AppNavGraph
import com.finance.outcome.presentation.navigation.OutcomeFeatureScreens

@Composable
fun AppContent(
    bottomBarItems: List<BottomBarItem>,
    featureNavigationApis: List<FeatureNavigationApi>,
    settingsUseCases: com.finance.settings.domain.usecase.SettingsUseCases
) {

    val navController = rememberNavController()
    val currentDestinationRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route

    val currentDestinationParentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.parent?.route

    val shouldShowBottomBar =
        featureNavigationApis.any { it.startDestinationRoute == currentDestinationRoute }
                || currentDestinationParentRoute == null && currentDestinationRoute != "splash" && currentDestinationRoute != "pin_verify"

    val notFABRoutes =
        listOf("settings_feature_navigation_route", "articles_feature_navigation_route")

    val shouldShowFAB =
        featureNavigationApis.any {
            it.startDestinationRoute == currentDestinationRoute
                    && currentDestinationParentRoute !in notFABRoutes
        }
                || currentDestinationParentRoute == null && currentDestinationRoute != "splash"

    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                BottomBar(
                    navController = navController,
                    currentDestinationParentRoute = currentDestinationParentRoute,
                    items = bottomBarItems,
                    settingsUseCases = settingsUseCases
                )
            }
        },
        floatingActionButton = {
            if (shouldShowFAB) {
                FloatingActionButton(
                    onClick = {
                        if (currentDestinationRoute == BriefFeatureScreens.startScreenDestination) {
                            navController.navigate(BriefFeatureScreens.CreateAccountScreen.route)
                        }
                        if (currentDestinationRoute == IncomeFeatureScreens.startScreenDestination) {
                            navController.navigate(IncomeFeatureScreens.AddIncomeScreen.route)
                        }
                        if (currentDestinationRoute == OutcomeFeatureScreens.startScreenDestination) {
                            navController.navigate(OutcomeFeatureScreens.AddOutcomeScreen.route)
                        }
                    },
                    containerColor = FinanceAppTheme.colors.primary,
                    contentColor = Color.White,
                    shape = CircleShape,
                    elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Добавить")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { paddingValues ->

        AppNavGraph(
            navController = navController,
            featureNavigationApis = featureNavigationApis,
            settingsUseCases = settingsUseCases,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            FinanceAppTheme.colors.primary, Color.White
                        )
                    )
                )
                .padding(
                    start = paddingValues.calculateStartPadding(LocalLayoutDirection.current),
                    end = paddingValues.calculateEndPadding(LocalLayoutDirection.current),
                )
                .systemBarsPadding()
                .background(Color.White)
        )
    }
}

@Composable
private fun BottomBar(
    navController: NavController,
    currentDestinationParentRoute: String?,
    items: List<BottomBarItem>,
    settingsUseCases: com.finance.settings.domain.usecase.SettingsUseCases,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color(0xFFF3EDF7)
    ) {
        items.forEach { bottomBarItem ->
            val itemLabel = stringResource(bottomBarItem.nameId)

            NavigationBarItem(
                selected = currentDestinationParentRoute == bottomBarItem.navigationRoute,
                onClick = {
                    if (currentDestinationParentRoute != bottomBarItem.navigationRoute) {
                        settingsUseCases.performTabHaptic()
                        navController.navigate(bottomBarItem.navigationRoute) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = FinanceAppTheme.colors.primary,
                    indicatorColor = FinanceAppTheme.colors.lightPrimary,
                ),
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(bottomBarItem.iconId),
                        contentDescription = itemLabel
                    )
                },
                label = {
                    Text(text = itemLabel, style = Typography().labelMedium)
                }
            )
        }
    }
}