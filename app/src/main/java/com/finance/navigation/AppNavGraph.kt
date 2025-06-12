package com.finance.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.register

@Composable
fun AppNavGraph(
    navController: NavHostController,
    featureNavigationApis: List<FeatureNavigationApi>,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = featureNavigationApis[0].navigationRoute,
        modifier = modifier
    ){
        featureNavigationApis.forEach {
            register(
                featureNavigationApi = it,
                navController = navController,
                modifier = modifier
            )
        }
    }

}