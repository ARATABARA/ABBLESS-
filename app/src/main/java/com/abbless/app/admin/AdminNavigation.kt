package com.abbless.app.admin

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.abbless.app.admin.screens.AdminDashboardScreen
import com.abbless.app.admin.security.SecurityManagerScreen
import com.abbless.app.admin.ai.AIManagerScreen
import com.abbless.app.admin.social.SocialManagerScreen
import com.abbless.app.admin.language.LanguageManagerScreen
import com.abbless.app.admin.lessons.LessonsManagerScreen
import com.abbless.app.admin.advancedstats.AdvancedStatisticsScreen
import com.abbless.app.admin.settings.SystemSettingsScreen
import com.abbless.app.admin.permissions.AdminPermissionsScreen

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
            SecurityManagerScreen()
        }

        composable("lessons") {
            LessonsManagerScreen()
        }

        composable("social") {
            SocialManagerScreen()
        }

        composable("ai") {
            AIManagerScreen()
        }

        composable("languages") {
            LanguageManagerScreen()
        }

        composable("statistics") {
            AdvancedStatisticsScreen()
        }

        composable("settings") {
            SystemSettingsScreen()
        }

        composable("permissions") {
            AdminPermissionsScreen()
        }

        composable("users") {
            Text("👥 Users Manager")
        }

        composable("announcements") {
            Text("📢 Announcements")
        }

        composable("payments") {
            Text("💳 Payments & Prices")
        }

        composable("activation_codes") {
            Text("🎟️ Activation Codes")
        }

        composable("backup") {
            Text("💾 Backup & Database")
        }
    }
}


