package com.abbless.app.admin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abbless.app.admin.auth.AdminSession

@Composable
fun AdminDashboardScreen(
    onSecurityClick: () -> Unit = {},
    onLessonsClick: () -> Unit = {},
    onUsersClick: () -> Unit = {},
    onSocialClick: () -> Unit = {},
    onAIClick: () -> Unit = {},
    onAnnouncementsClick: () -> Unit = {},
    onPaymentsClick: () -> Unit = {},
    onPaymentMethodsClick: () -> Unit = {},
    onActivationCodesClick: () -> Unit = {},
    onStatisticsClick: () -> Unit = {},
    onLanguagesClick: () -> Unit = {},
    onBackupClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(20.dp),

        verticalArrangement =
            Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "ABBLESS Admin Panel",
            style =
                MaterialTheme.typography
                    .headlineMedium
        )

        Text(
            text = "Administration",
            style =
                MaterialTheme.typography
                    .titleMedium
        )

        Button(
            onClick = onSecurityClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🔐 Security")
        }

        Button(
            onClick = onLessonsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📚 Lessons Manager")
        }

        Button(
            onClick = onUsersClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("👥 Users Manager")
        }

        Button(
            onClick = onSocialClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("💬 Social Manager")
        }

        Button(
            onClick = onAIClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🤖 AI Manager")
        }

        Button(
            onClick = onAnnouncementsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📢 Announcements")
        }

        Button(
            onClick = onPaymentsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("💳 Payments & Prices")
        }

        Button(
            onClick = onPaymentMethodsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📱 Payment Methods")
        }

        Button(
            onClick = onActivationCodesClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🎟️ Activation Codes")
        }

        Button(
            onClick = onStatisticsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📊 Statistics")
        }

        Button(
            onClick = onLanguagesClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🌍 Languages")
        }

        Button(
            onClick = onBackupClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("💾 Backup & Database")
        }

        Button(
            onClick = onSettingsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("⚙️ App Settings")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = {
                AdminSession.logout()
                onLogoutClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🚪 Logout")
        }
    }
}
