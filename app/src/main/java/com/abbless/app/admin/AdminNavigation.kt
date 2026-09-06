package com.abbless.app.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.abbless.app.admin.announcements.AnnouncementScreen
import com.abbless.app.admin.auth.ChangePasswordScreen
import com.abbless.app.admin.lessons.LessonsManagerScreen
import com.abbless.app.admin.payments.ActivationCodeManagerScreen
import com.abbless.app.admin.payments.PaymentAdminScreen
import com.abbless.app.admin.payments.PaymentMethodsScreen
import com.abbless.app.admin.payments.SubscriptionManagerScreen
import com.abbless.app.admin.statistics.StatisticsScreen
import com.abbless.app.admin.users.AdminUserScreen
import com.abbless.app.admin.screens.AdminDashboardScreen
import com.abbless.app.admin.social.SocialManagerScreen

@Composable
fun AdminNavigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "admin_dashboard"
    ) {

        // =========================
        // ADMIN DASHBOARD
        // =========================

        composable("admin_dashboard") {

            AdminDashboardScreen(

                onSecurityClick = {
                    navController.navigate("security")
                },

                onLessonsClick = {
                    navController.navigate("lessons")
                },

                onUsersClick = {
                    navController.navigate("users")
                },

                onSocialClick = {
                    navController.navigate("social")
                },

                onAIClick = {
                    navController.navigate("ai")
                },

                onAnnouncementsClick = {
                    navController.navigate("announcements")
                },

                onPaymentsClick = {
                    navController.navigate("payments")
                },

                onActivationCodesClick = {
                    navController.navigate("activation_codes")
                },

                onStatisticsClick = {
                    navController.navigate("statistics")
                },

                onLanguagesClick = {
                    navController.navigate("languages")
                },

                onBackupClick = {
                    navController.navigate("backup")
                },

                onSettingsClick = {
                    navController.navigate("settings")
                },

                onLogoutClick = {
                    navController.navigate("admin_login") {
                        popUpTo("admin_dashboard") {
                            inclusive = true
                        }
                    }
                }

                // Payment Methods button will be connected
                // from AdminDashboardScreen.
            )
        }


        // =========================
        // SECURITY
        // =========================

        composable("security") {

            ChangePasswordScreen(
                onPasswordChanged = {
                    navController.popBackStack()
                }
            )
        }


        // =========================
        // LESSONS
        // =========================

        composable("lessons") {

            LessonsManagerScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }


        // =========================
        // USERS
        // =========================

        composable("users") {

            AdminUserScreen()
        }


        // =========================
        // SOCIAL MANAGER
        // =========================

        composable("social") {

            SocialManagerScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }


        // =========================
        // AI MANAGER
        // =========================

        composable("ai") {

            androidx.compose.material3.Text(
                text = """
                    🤖 ABBLESS AI Manager

                    AI management.

                    • AI settings
                    • AI responses
                    • AI languages
                    • AI usage
                    • AI controls
                """.trimIndent()
            )
        }


        // =========================
        // ANNOUNCEMENTS
        // =========================

        composable("announcements") {

            AnnouncementScreen()
        }


        // =========================
        // PAYMENT MANAGER
        // =========================

        composable("payments") {

            PaymentAdminScreen()
        }


        // =========================
        // PAYMENT METHODS
        // =========================

        composable("payment_methods") {

            PaymentMethodsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }


        // =========================
        // ACTIVATION CODES
        // =========================

        composable("activation_codes") {

            ActivationCodeManagerScreen()
        }


        // =========================
        // SUBSCRIPTIONS
        // =========================

        composable("subscriptions") {

            SubscriptionManagerScreen()
        }


        // =========================
        // STATISTICS
        // =========================

        composable("statistics") {

            StatisticsScreen()
        }


        // =========================
        // LANGUAGES
        // =========================

        composable("languages") {

            androidx.compose.material3.Text(
                text = """
                    🌍 Language Manager

                    Kirundi
                    Français
                    English
                    Kiswahili
                    Español
                    العربية
                """.trimIndent()
            )
        }


        // =========================
        // BACKUP & DATABASE
        // =========================

        composable("backup") {

            androidx.compose.material3.Text(
                text = """
                    💾 Backup & Database

                    Database management.

                    • Backup
                    • Restore
                    • Database information
                """.trimIndent()
            )
        }


        // =========================
        // SETTINGS
        // =========================

        composable("settings") {

            ChangePasswordScreen(
                onPasswordChanged = {
                    navController.popBackStack()
                }
            )
        }
    }
}
