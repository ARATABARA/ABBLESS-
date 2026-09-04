package com.abbless.app.auth.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.abbless.app.auth.data.AuthRepository

@Composable
fun SwitchAccountScreen(
    onAccountSwitched: () -> Unit,
    onAddAccount: () -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val accounts = remember {
        AuthRepository.getAllAccounts(context)
    }

    var selectedPhone by remember {
        mutableStateOf<String?>(null)
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
            text = "Switch Account",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Hitamwo account ushaka gukoresha."
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(accounts) { account ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = account.name,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = account.phoneNumber
                        )

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Button(
                            onClick = {
                                selectedPhone =
                                    account.phoneNumber

                                password = ""
                                message = ""
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Switch to this account")
                        }

                        if (
                            selectedPhone ==
                            account.phoneNumber
                        ) {

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
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Button(
                                onClick = {

                                    val user =
                                        AuthRepository.login(
                                            context = context,
                                            phoneNumber =
                                                account.phoneNumber,
                                            password =
                                                password
                                        )

                                    if (user != null) {

                                        onAccountSwitched()

                                    } else {

                                        message =
                                            "Password si yo ❌"
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Confirm Switch")
                            }
                        }
                    }
                }
            }
        }

        if (message.isNotEmpty()) {

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(message)
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = onAddAccount,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("➕ Add Another Account")
        }

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        TextButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

