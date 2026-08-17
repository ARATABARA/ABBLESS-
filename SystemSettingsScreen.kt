package com.abbless.app.admin.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SystemSettingsScreen() {

    var settings by remember {
        mutableStateOf(
            SystemSettingsRepository
                .getSettings()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "⚙️ System Settings",
            style =
                MaterialTheme
                    .typography
                    .headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        SettingSwitch(
            title = "Maintenance Mode",
            checked =
                settings.maintenanceMode
        ) {

            settings =
                settings.copy(
                    maintenanceMode = it
                )
        }

        SettingSwitch(
            title = "User Registration",
            checked =
                settings.registrationEnabled
        ) {

            settings =
                settings.copy(
                    registrationEnabled = it
                )
        }

        SettingSwitch(
            title = "Messages",
            checked =
                settings.messagingEnabled
        ) {

            settings =
                settings.copy(
                    messagingEnabled = it
                )
        }

        SettingSwitch(
            title = "ABBLESS AI",
            checked =
                settings.aiEnabled
        ) {

            settings =
                settings.copy(
                    aiEnabled = it
                )
        }

        SettingSwitch(
            title = "Quiz",
            checked =
                settings.quizEnabled
        ) {

            settings =
                settings.copy(
                    quizEnabled = it
                )
        }

        SettingSwitch(
            title = "Notifications",
            checked =
                settings.notificationsEnabled
        ) {

            settings =
                settings.copy(
                    notificationsEnabled = it
                )
        }

        SettingSwitch(
            title = "Lessons",
            checked =
                settings.lessonsEnabled
        ) {

            settings =
                settings.copy(
                    lessonsEnabled = it
                )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {

                SystemSettingsRepository
                    .updateSettings(settings)
            },

            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text("💾 Save Settings")
        }
    }
}

@Composable
private fun SettingSwitch(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Text(title)

        Switch(
            checked = checked,
            onCheckedChange =
                onCheckedChange
        )
    }
}

