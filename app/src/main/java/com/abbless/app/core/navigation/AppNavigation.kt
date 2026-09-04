package com.abbless.app.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.abbless.app.auth.data.AuthRepository
import com.abbless.app.auth.screens.LoginScreen
import com.abbless.app.auth.screens.RegisterScreen
import com.abbless.app.auth.screens.ForgotPasswordScreen
import com.abbless.app.auth.screens.SwitchAccountScreen

import com.abbless.app.home.HomeScreen

import com.abbless.app.admin.auth.AdminLoginScreen
import com.abbless.app.admin.AdminNavigation

object Routes {

    const val REGISTER = "register"
    const val LOGIN = "login"
    const val FORGOT_PASSWORD = "forgot_password"
    const val SWITCH_ACCOUNT = "switch_account"
    const val HOME = "home"

    const val ADMIN_LOGIN = "admin_login"
    const val ADMIN_PANEL = "admin_panel"
}

@Composable
fun AppNavigation() {

    val context = LocalContext.current

    val navController =
        rememberNavController()

    val activeUser =
        remember {
            AuthRepository.getActiveUser(context)
        }

    val startDestination =
        if (activeUser != null) {
            Routes.HOME
        } else {
            Routes.REGISTER
        }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        // =========================
        // REGISTER
        // =========================

        composable(Routes.REGISTER) {

            RegisterScreen(

                onRegisterSuccess = {

                    navController.navigate(
                        Routes.LOGIN
                    ) {

                        popUpTo(
                            Routes.REGISTER
                        ) {
                            inclusive = true
                        }
                    }
                },

                onLogin = {

                    navController.navigate(
                        Routes.LOGIN
                    )
                }
            )
        }

        // =========================
        // LOGIN
        // =========================

        composable(Routes.LOGIN) {

            LoginScreen(

                onLogin = {

                    navController.navigate(
                        Routes.HOME
                    ) {

                        popUpTo(
                            Routes.LOGIN
                        ) {
                            inclusive = true
                        }
                    }
                },

                onForgotPassword = {

                    navController.navigate(
                        Routes.FORGOT_PASSWORD
                    )
                }
            )
        }

        // =========================
        // FORGOT PASSWORD
        // =========================

        composable(
            Routes.FORGOT_PASSWORD
        ) {

            ForgotPasswordScreen(

                onPasswordChanged = {

                    navController.navigate(
                        Routes.LOGIN
                    ) {

                        popUpTo(
                            Routes.FORGOT_PASSWORD
                        ) {
                            inclusive = true
                        }
                    }
                },

                onBackToLogin = {

                    navController.popBackStack()
                }
            )
        }

        // =========================
        // SWITCH ACCOUNT
        // =========================

        composable(
            Routes.SWITCH_ACCOUNT
        ) {

            SwitchAccountScreen(

                onAccountSwitched = {

                    navController.navigate(
                        Routes.HOME
                    ) {

                        popUpTo(
                            Routes.SWITCH_ACCOUNT
                        ) {
                            inclusive = true
                        }
                    }
                },

                onAddAccount = {

                    navController.navigate(
                        Routes.LOGIN
                    )
                },

                onBack = {

                    navController.popBackStack()
                }
            )
        }

        // =========================
        // HOME
        // =========================

        composable(Routes.HOME) {

            HomeScreen(

                onSwitchAccount = {

                    navController.navigate(
                        Routes.SWITCH_ACCOUNT
                    )
                },

                onAdminLogin = {

                    navController.navigate(
                        Routes.ADMIN_LOGIN
                    )
                },

                onLogout = {

                    AuthRepository.logout(
                        context
                    )

                    navController.navigate(
                        Routes.LOGIN
                    ) {

                        popUpTo(
                            Routes.HOME
                        ) {
                            inclusive = true
                        }
                    }
                },

                onLessons = {
                    // Lessons screen will be connected here
                },

                onMessages = {
                    // Messages screen will be connected here
                },

                onNotifications = {
                    // Notifications screen will be connected here
                },

                onAI = {
                    // ABBLESS AI screen will be connected here
                }
            )
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
                navController = navController
            )
        }
    }
}

