package com.abbless.app.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.abbless.app.auth.screens.LoginScreen
import com.abbless.app.auth.screens.RegisterScreen
import com.abbless.app.auth.screens.SplashScreen

import com.abbless.app.admin.auth.AdminLoginScreen
import com.abbless.app.admin.AdminNavigation

object Routes {

    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"

    const val ADMIN_LOGIN = "admin_login"
    const val ADMIN_PANEL = "admin_panel"
}

@Composable
fun AppNavigation() {

    val navController =
        rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.REGISTER
    ) {

        // =========================
        // SPLASH
        // =========================

        composable(Routes.SPLASH) {

            SplashScreen(

                onLogin = {

                    navController.navigate(
                        Routes.LOGIN
                    ) {

                        popUpTo(
                            Routes.SPLASH
                        ) {
                            inclusive = true
                        }
                    }
                },

                onHome = {

                    navController.navigate(
                        Routes.HOME
                    ) {

                        popUpTo(
                            Routes.SPLASH
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // =========================
        // USER LOGIN
        // =========================

        composable(Routes.LOGIN) {

            LoginScreen()
        }

        // =========================
        // REGISTER
        // =========================

        composable(Routes.REGISTER) {

            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.REGISTER) {
                            inclusive = true
                        }
                    }
                },
                onLogin = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

        // =========================
        // USER HOME
        // =========================

        composable(Routes.HOME) {

            // HomeScreen izokwongerwamwo hano
        }

        // =========================
        // ADMIN LOGIN
        // =========================

        composable(
            Routes.ADMIN_LOGIN
        ) {

            AdminLoginScreen(

                onLoginSuccess = {

                    navController.navigate(
                        Routes.ADMIN_PANEL
                    ) {

                        popUpTo(
                            Routes.ADMIN_LOGIN
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // =========================
        // ADMIN PANEL
        // =========================

        composable(
            Routes.ADMIN_PANEL
        ) {

            AdminNavigation(
                navController =
                    navController
            )
        }
    }
}





