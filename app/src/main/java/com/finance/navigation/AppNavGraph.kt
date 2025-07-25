package com.finance.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.finance.common.navigation.FeatureNavigationApi
import com.finance.common.navigation.register
import com.finance.settings.domain.usecase.SettingsUseCases
import com.finance.settings.presentation.screens.pincode.PinCodeVerifyScreen
import com.finance.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    featureNavigationApis: List<FeatureNavigationApi>,
    settingsUseCases: SettingsUseCases,
    modifier: Modifier = Modifier
) {
    var isPinRequired by remember { mutableStateOf(false) }
    var isCheckingPin by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isPinRequired = settingsUseCases.isPinCodeSet()
        isCheckingPin = false
    }

    if (isCheckingPin) {
        // Show loading or splash while checking pin
        return
    }

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
                if (isPinRequired) {
                    navController.navigate("pin_verify") {
                        popUpTo("splash") { inclusive = true }
                    }
                } else {
                    navController.navigate(featureNavigationApis[0].navigationRoute) {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            }
        }

        composable("pin_verify") {
            PinCodeVerifyScreen(
                settingsUseCases = settingsUseCases,
                onPinVerified = {
                    navController.navigate(featureNavigationApis[0].navigationRoute) {
                        popUpTo("pin_verify") { inclusive = true }
                    }
                }
            )
        }
    }

}