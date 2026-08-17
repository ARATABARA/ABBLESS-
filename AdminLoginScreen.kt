package com.abbless.app.admin.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AdminLoginScreen(
    onLoginSuccess: () -> Unit
) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "🔐 ABBLESS Admin Login",
            style =
                MaterialTheme
                    .typography
                    .headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                errorMessage = ""
            },
            label = {
                Text("Username")
            },
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = ""
            },
            label = {
                Text("Password")
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

                val success =
                    AdminAuthRepository.login(
                        username,
                        password
                    )

                if (success) {
                    onLoginSuccess()
                } else {
                    errorMessage =
                        "Username canke password si vyo."
                }
            },
            modifier =
                Modifier.fillMaxWidth()
        ) {
            Text("🔓 Login")
        }

        if (errorMessage.isNotEmpty()) {

            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )

            Text(
                text = errorMessage
            )
        }
    }
}
