package com.abbless.app.admin.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ChangePasswordScreen(
    onPasswordChanged: () -> Unit
) {

    var oldPassword by remember {
        mutableStateOf("")
    }

    var newPassword by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var message by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "🔑 Change Admin Password",
            style =
                MaterialTheme
                    .typography
                    .headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = oldPassword,
            onValueChange = {
                oldPassword = it
            },
            label = {
                Text("Current password")
            },
            visualTransformation =
                PasswordVisualTransformation(),
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = newPassword,
            onValueChange = {
                newPassword = it
            },
            label = {
                Text("New password")
            },
            visualTransformation =
                PasswordVisualTransformation(),
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            label = {
                Text("Confirm new password")
            },
            visualTransformation =
                PasswordVisualTransformation(),
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                when {

                    newPassword.length < 8 -> {
                        message =
                            "Password ibwirizwa kuba n'inyuguti 8 canke zirenga."
                    }

                    newPassword != confirmPassword -> {
                        message =
                            "Passwords nshasha ntizihura."
                    }

                    else -> {

                        val changed =
                            AdminAuthRepository
                                .changePassword(
                                    oldPassword,
                                    newPassword
                                )

                        if (changed) {

                            message =
                                "Password yahindutse neza ✅"

                            oldPassword = ""
                            newPassword = ""
                            confirmPassword = ""

                            onPasswordChanged()

                        } else {

                            message =
                                "Current password siyo."
                        }
                    }
                }
            },
            modifier =
                Modifier.fillMaxWidth()
        ) {

            Text("💾 Change Password")
        }

        Spacer(
            modifier =
                Modifier.height(12.dp)
        )

        if (message.isNotEmpty()) {

            Text(message)
        }
    }
}
