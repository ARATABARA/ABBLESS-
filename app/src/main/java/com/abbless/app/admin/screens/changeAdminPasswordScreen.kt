package com.abbless.app.admin.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChangeAdminPasswordScreen() {

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
            .padding(20.dp)
    ) {

        Text(
            text = "🔑 Change Admin Password",
            style = MaterialTheme.typography.headlineMedium
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
                Text("Current Password")
            }
        )

        OutlinedTextField(
            value = newPassword,
            onValueChange = {
                newPassword = it
            },
            label = {
                Text("New Password")
            }
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            label = {
                Text("Confirm New Password")
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                message = when {

                    newPassword.length < 8 ->
                        "Password nshasha ni ngufi."

                    newPassword != confirmPassword ->
                        "Passwords ntizisa."

                    else ->
                        "Password yahinduwe neza."
                }
            }
        ) {
            Text("Change Password")
        }

        if (message.isNotEmpty()) {

            Text(
                text = message,
                modifier =
                    Modifier.padding(top = 12.dp)
            )
        }
    }
}
