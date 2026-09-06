package com.abbless.app.core.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.abbless.app.auth.data.AuthRepository
import com.abbless.app.auth.screens.ForgotPasswordScreen
import com.abbless.app.auth.screens.LoginScreen
import com.abbless.app.auth.screens.RegisterScreen
import com.abbless.app.auth.screens.SwitchAccountScreen

import com.abbless.app.home.HomeScreen

import com.abbless.app.lessons.LessonsScreen
import com.abbless.app.quiz.screens.QuizScreen
import com.abbless.app.ai.chat.AIScreen

import com.abbless.app.social.profile.ProfileScreen

import com.abbless.app.settings.SettingsScreen

import com.abbless.app.admin.auth.AdminLoginScreen
import com.abbless.app.admin.AdminNavigation

import com.abbless.app.core.Routes

@Composable
fun AppNavigation(
    darkMode: Boolean = true,
    onDarkModeChange: (Boolean) -> Unit = {}
) {

    val context = LocalContext.current

    val navController = rememberNavController()

    val activeUser = remember {
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

                    navController.navigate(Routes.LOGIN) {
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
        // LOGIN
        // =========================

        composable(Routes.LOGIN) {

            LoginScreen(
                onLogin = {

                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) {
                            inclusive = true
                        }
                    }
                },
                onForgotPassword = {
                    navController.navigate(Routes.FORGOT_PASSWORD)
                }
            )
        }

        // =========================
        // FORGOT PASSWORD
        // =========================

        composable(Routes.FORGOT_PASSWORD) {

            ForgotPasswordScreen(
                onPasswordChanged = {

                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.FORGOT_PASSWORD) {
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

        composable(Routes.SWITCH_ACCOUNT) {

            SwitchAccountScreen(
                onAccountSwitched = {

                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.SWITCH_ACCOUNT) {
                            inclusive = true
                        }
                    }
                },
                onAddAccount = {
                    navController.navigate(Routes.LOGIN)
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

                onProfile = {
                    navController.navigate(Routes.PROFILE)
                },

                onSwitchAccount = {
                    navController.navigate(Routes.SWITCH_ACCOUNT)
                },

                onFriends = {
                    navController.navigate(Routes.FRIENDS)
                },

                onGroups = {
                    navController.navigate(Routes.GROUPS)
                },

                onSaved = {
                    navController.navigate(Routes.SAVED)
                },

                onFavorites = {
                    navController.navigate(Routes.FAVORITES)
                },

                onLanguages = {
                    navController.navigate(Routes.LANGUAGES)
                },

                onSettings = {
                    navController.navigate(Routes.SETTINGS)
                },

                onHelp = {
                    navController.navigate(Routes.HELP)
                },

                onAbout = {
                    navController.navigate(Routes.ABOUT)
                },

                onAdminLogin = {
                    navController.navigate(Routes.ADMIN_LOGIN)
                },

                onLogout = {

                    AuthRepository.logout(context)

                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.HOME) {
                            inclusive = true
                        }
                    }
                },

                onLessons = {
                    navController.navigate(Routes.LESSONS)
                },

                onMessages = {
                    navController.navigate(Routes.MESSAGES)
                },

                onNotifications = {
                    navController.navigate(Routes.NOTIFICATIONS)
                },

                onAI = {
                    navController.navigate(Routes.AI)
                }
            )
        }

        // =========================
        // PROFILE
        // =========================

        composable(Routes.PROFILE) {

            val user = AuthRepository.getActiveUser(context)

            ProfileScreen(
                user = user,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // =========================
        // SETTINGS
        // =========================

        composable(Routes.SETTINGS) {

            SettingsScreen(
                darkMode = darkMode,
                onDarkModeChange = onDarkModeChange,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // =========================
        // LESSONS
        // =========================

        composable(Routes.LESSONS) {

            LessonsScreen()
        }

        // =========================
        // QUIZ
        // =========================

        composable(Routes.QUIZ) {

            QuizScreen()
        }

        // =========================
        // AI
        // =========================

        composable(Routes.AI) {

            AIScreen()
        }

        // =========================
        // MENU OUTPUT ROUTES
        // =========================

        composable(Routes.FRIENDS) {
            MenuOutputScreen(
                title = "👥 Friends",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.GROUPS) {
            MenuOutputScreen(
                title = "👨‍👩‍👧 Groups",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.SAVED) {
            MenuOutputScreen(
                title = "💾 Saved",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.FAVORITES) {
            MenuOutputScreen(
                title = "❤️ Favorites",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.LANGUAGES) {
            MenuOutputScreen(
                title = "🌍 Languages",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.MESSAGES) {
            MenuOutputScreen(
                title = "💬 Messages",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.NOTIFICATIONS) {
            MenuOutputScreen(
                title = "🔔 Notifications",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.HELP) {
            MenuOutputScreen(
                title = "❓ Help & Support",
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.ABOUT) {
            MenuOutputScreen(
                title = "ℹ️ About ABBLESS",
                onBack = { navController.popBackStack() }
            )
        }

        // =========================
        // ADMIN LOGIN
        // =========================

        composable(Routes.ADMIN_LOGIN) {

            AdminLoginScreen(
                onLoginSuccess = {

                    navController.navigate(Routes.ADMIN_PANEL) {
                        popUpTo(Routes.ADMIN_LOGIN) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // =========================
        // ADMIN PANEL
        // =========================

        composable(Routes.ADMIN_PANEL) {

            AdminNavigation(
                navController = navController
            )
        }
    }
}

@Composable
private fun MenuOutputScreen(
    title: String,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Iyi section iriko irategurwa."
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(
            onClick = onBack
        ) {
            Text("⬅️ Back")
        }
    }
}
