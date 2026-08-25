package com.abbless.app.auth.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.abbless.app.auth.data.AuthRepository

@Composable
fun LoginScreen(
    onLogin: () -> Unit = {}
) {

    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var message by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Login to ABBLESS",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {

                val user = AuthRepository.login(
                    context = context,
                    email = email.trim(),
                    password = password
                )

                if (user != null) {

                    message = "Welcome ${user.name} ✅"

                    onLogin()

                } else {

                    message = "Email canke password si vyo ❌"

                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🔐 Login")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        if (message.isNotEmpty()) {
            Text(message)
        }
    }
}
