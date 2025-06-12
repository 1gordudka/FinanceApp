package com.finance.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.register
import com.finance.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    featureNavigationApis: List<FeatureNavigationApi>,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = "splash",
        modifier = modifier
    ){
        featureNavigationApis.forEach {
            register(
                featureNavigationApi = it,
                navController = navController,
                modifier = modifier
            )
        }

        composable("splash"){
            SplashScreen {
                navController.navigate(featureNavigationApis[0].navigationRoute) {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }
    }

}