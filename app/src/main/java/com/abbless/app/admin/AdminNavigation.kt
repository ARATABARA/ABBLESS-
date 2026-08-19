package com.abbless.app.admin

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.abbless.app.admin.announcements.AnnouncementScreen
import com.abbless.app.admin.auth.ChangePasswordScreen
import com.abbless.app.admin.lessons.LessonsManagerScreen
import com.abbless.app.admin.payments.ActivationCodeManagerScreen
import com.abbless.app.admin.payments.PaymentAdminScreen
import com.abbless.app.admin.payments.SubscriptionManagerScreen
import com.abbless.app.admin.statistics.StatisticsScreen
import com.abbless.app.admin.users.AdminUserScreen
import com.abbless.app.admin.screens.AdminDashboardScreen

@Composable
fun AdminNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "admin_dashboard"
    ) {

        composable("admin_dashboard") {
            AdminDashboardScreen(
                onLogoutClick = {
                    navController.navigate("admin_login") {
                        popUpTo("admin_dashboard") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("security") {
            Text("🔐 Security Manager")
        }

        composable("lessons") {
            LessonsManagerScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("users") {
            AdminUserScreen()
        }

        composable("announcements") {
            AnnouncementScreen()
        }

        composable("payments") {
            PaymentAdminScreen()
        }

        composable("activation_codes") {
            ActivationCodeManagerScreen()
        }

        composable("subscriptions") {
            SubscriptionManagerScreen()
        }

        composable("statistics") {
            StatisticsScreen()
        }

        composable("settings") {
            ChangePasswordScreen(
                onPasswordChanged = {
                    navController.popBackStack()
                }
            )
        }

        composable("backup") {
            Text("💾 Backup & Database")
        }

        composable("ai") {
            Text("🤖 AI Manager — coming soon")
        }

        composable("social") {
            Text("💬 Social Manager — coming soon")
        }

        composable("languages") {
            Text("🌍 Language Manager — coming soon")
        }
    }
}
