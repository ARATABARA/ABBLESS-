package com.abbless.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.abbless.app.core.Routes
import com.abbless.app.ui.screens.SplashScreen
import com.abbless.app.ui.screens.LoginScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {

        composable(Routes.SPLASH) {

            SplashScreen()

        }

        composable(Routes.LOGIN) {

            LoginScreen(
                onLogin = {

                    navController.navigate(
                        Routes.HOME
                    )

                }
            )

        }

    }
}
