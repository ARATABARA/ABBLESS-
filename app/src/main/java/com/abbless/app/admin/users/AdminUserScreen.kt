package com.abbless.app.admin.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdminUserScreen() {

    var search by remember {
        mutableStateOf("")
    }

    var users by remember {
        mutableStateOf(
            AdminUserRepository.getUsers()
        )
    }

    val filteredUsers =
        users.filter {

            it.name.contains(
                search,
                ignoreCase = true
            ) ||
            it.email.contains(
                search,
                ignoreCase = true
            )
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "👥 User Manager",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = search,
            onValueChange = {
                search = it
            },
            label = {
                Text("Search users")
            },
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn {

            items(filteredUsers) { user ->

                Card(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 5.dp
                            )
                ) {

                    Column(
                        modifier =
                            Modifier.padding(12.dp)
                    ) {

                        Text(user.name)

                        Text(user.email)

                        Text(
                            if (user.active)
                                "🟢 Active"
                            else
                                "🔴 Suspended"
                        )

                        Row {

                            Button(
                                onClick = {

                                    if (user.active) {

                                        AdminUserRepository
                                            .suspendUser(
                                                user.id
                                            )

                                    } else {

                                        AdminUserRepository
                                            .activateUser(
                                                user.id
                                            )
                                    }

                                    users =
                                        AdminUserRepository
                                            .getUsers()
                                }
                            ) {

                                Text(
                                    if (user.active)
                                        "Suspend"
                                    else
                                        "Activate"
                                )
                            }

                            Spacer(
                                modifier =
                                    Modifier.width(8.dp)
                            )

                            Button(
                                onClick = {

                                    AdminUserRepository
                                        .deleteUser(
                                            user.id
                                        )

                                    users =
                                        AdminUserRepository
                                            .getUsers()
                                }
                            ) {

                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
