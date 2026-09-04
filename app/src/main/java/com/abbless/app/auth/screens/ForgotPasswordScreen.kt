package com.abbless.app.auth.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.abbless.app.auth.data.AuthRepository

@Composable
fun ForgotPasswordScreen(
    onPasswordChanged: () -> Unit,
    onBackToLogin: () -> Unit
) {
    val context = LocalContext.current

    var phoneNumber by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Forgot Password?",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            label = {
                Text("Phone Number")
            },
            placeholder = {
                Text("+257...")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = dateOfBirth,
            onValueChange = {
                dateOfBirth = it
            },
            label = {
                Text("Date of Birth")
            },
            placeholder = {
                Text("DD/MM/YYYY")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Nimara kwemeza amakuru yawe, shiraho password nshasha."
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
                Text("New Password")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
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
                Text("Confirm New Password")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {

                when {

                    phoneNumber.isBlank() ||
                    dateOfBirth.isBlank() ||
                    newPassword.isBlank() ||
                    confirmPassword.isBlank() -> {

                        message = "Uzuza amakuru yose."
                    }

                    newPassword != confirmPassword -> {

                        message = "Passwords ntizisa."
                    }

                    newPassword.length < 8 -> {

                        message =
                            "Password ikwiye kuba ifise nibura inyuguti 8."
                    }

                    else -> {

                        val changed =
                            AuthRepository.resetPassword(
                                context = context,
                                phoneNumber = phoneNumber.trim(),
                                dateOfBirth = dateOfBirth.trim(),
                                newPassword = newPassword
                            )

                        if (changed) {

                            message =
                                "Password yahinduwe neza ✅"

                            onPasswordChanged()

                        } else {

                            message =
                                "Phone Number canke Date of Birth si vyo ❌"
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Change Password")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        TextButton(
            onClick = onBackToLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Login")
        }

        if (message.isNotEmpty()) {

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(message)
        }
    }
}
0
