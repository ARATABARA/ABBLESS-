@file:OptIn(ExperimentalMaterial3Api::class)

package com.abbless.app.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onSwitchAccount: () -> Unit = {},
    onAdminLogin: () -> Unit = {},
    onLogout: () -> Unit = {},
    onLessons: () -> Unit = {},
    onMessages: () -> Unit = {},
    onNotifications: () -> Unit = {},
    onAI: () -> Unit = {}
) {

    var selectedTab by remember {
        mutableStateOf(0)
    }

    var menuExpanded by remember {
        mutableStateOf(false)
    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text(
                        text = "ABBLESS",
                        style = MaterialTheme.typography.titleLarge
                    )
                },

                navigationIcon = {

                    Box {

                        IconButton(
                            onClick = {
                                menuExpanded = true
                            }
                        ) {
                            Text("☰")
                        }

                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = {
                                menuExpanded = false
                            }
                        ) {

                            DropdownMenuItem(
                                text = {
                                    Text("👤 My Profile")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("🔄 Switch Account")
                                },
                                onClick = {
                                    menuExpanded = false
                                    onSwitchAccount()
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("👥 Friends")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("👨‍👩‍👧 Groups")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("💾 Saved")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("❤️ Favorites")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("🌍 Languages")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("⚙️ Settings")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("❓ Help & Support")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("ℹ️ About ABBLESS")
                                },
                                onClick = {
                                    menuExpanded = false
                                }
                            )

                            HorizontalDivider()

                            DropdownMenuItem(
                                text = {
                                    Text("🔐 Admin Login")
                                },
                                onClick = {
                                    menuExpanded = false
                                    onAdminLogin()
                                }
                            )

                            DropdownMenuItem(
                                text = {
                                    Text("🚪 Logout")
                                },
                                onClick = {
                                    menuExpanded = false
                                    onLogout()
                                }
                            )
                        }
                    }
                },

                actions = {

                    IconButton(
                        onClick = {
                            // Search will be connected later
                        }
                    ) {
                        Text("🔍")
                    }

                    IconButton(
                        onClick = {
                            selectedTab = 3
                            onNotifications()
                        }
                    ) {
                        Text("🔔")
                    }
                }
            )
        },

        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                    },
                    icon = {
                        Text("🏠")
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                        onLessons()
                    },
                    icon = {
                        Text("📚")
                    },
                    label = {
                        Text("Lessons")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = {
                        selectedTab = 2
                        onMessages()
                    },
                    icon = {
                        Text("💬")
                    },
                    label = {
                        Text("Messages")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = {
                        selectedTab = 3
                        onNotifications()
                    },
                    icon = {
                        Text("🔔")
                    },
                    label = {
                        Text("Notifications")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 4,
                    onClick = {
                        selectedTab = 4
                        onAI()
                    },
                    icon = {
                        Text("🤖")
                    },
                    label = {
                        Text("AI")
                    }
                )
            }
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            when (selectedTab) {

                0 -> {

                    Text(
                        text =
                            "Bienvenue muri ABBLESS 👋",
                        style =
                            MaterialTheme.typography
                                .headlineSmall
                    )

                    Spacer(
                        modifier =
                            Modifier.height(12.dp)
                    )

                    Text(
                        text = "Ishure rya Bose"
                    )

                    Spacer(
                        modifier =
                            Modifier.height(25.dp)
                    )

                    Text(
                        text =
                            "📚 Learn • 🎥 Watch • 💬 Connect • 🤖 Ask AI"
                    )
                }

                1 -> {

                    Text(
                        text = "📚 Lessons",
                        style =
                            MaterialTheme.typography
                                .headlineSmall
                    )
                }

                2 -> {

                    Text(
                        text = "💬 Messages",
                        style =
                            MaterialTheme.typography
                                .headlineSmall
                    )
                }

                3 -> {

                    Text(
                        text = "🔔 Notifications",
                        style =
                            MaterialTheme.typography
                                .headlineSmall
                    )
                }

                4 -> {

                    Text(
                        text = "🤖 ABBLESS AI",
                        style =
                            MaterialTheme.typography
                                .headlineSmall
                    )
                }
            }
        }
    }
}

