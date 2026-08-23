package com.abbless.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.abbless.app.core.Routes
import com.abbless.app.auth.screens.RegisterScreen
import com.abbless.app.ui.screens.PresentationScreen
import com.abbless.app.ui.screens.LoginScreen
import com.abbless.app.home.HomeScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.REGISTER
    ) {

        composable(Routes.REGISTER) {

            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Routes.PRESENTATION)
                },
                onLogin = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

        composable(Routes.PRESENTATION) {

            PresentationScreen(
                onContinue = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.PRESENTATION) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.LOGIN) {

            LoginScreen(
                onLogin = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen()
        }
    }
}
