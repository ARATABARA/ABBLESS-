package com.abbless.app.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    var selectedTab by remember {
        mutableStateOf(0)
    }

    Scaffold(

        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                    },
                    icon = { Text("📚") },
                    label = { Text("Lessons") }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                    },
                    icon = { Text("💬") },
                    label = { Text("Messages") }
                )

                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = {
                        selectedTab = 2
                    },
                    icon = { Text("🔔") },
                    label = { Text("Notifications") }
                )

                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = {
                        selectedTab = 3
                    },
                    icon = { Text("🤖") },
                    label = { Text("AI") }
                )

                NavigationBarItem(
                    selected = selectedTab == 4,
                    onClick = {
                        selectedTab = 4
                    },
                    icon = { Text("📝") },
                    label = { Text("Quiz") }
                )
            }
        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally

        ) {

            Text(
                text = "ABBLESS",
                style =
                    MaterialTheme.typography.headlineLarge
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            when (selectedTab) {

                0 -> Text("📚 Bienvenue muri Lessons")

                1 -> Text("💬 Messages")

                2 -> Text("🔔 Notifications")

                3 -> Text("🤖 ABBLESS AI")

                4 -> Text("📝 Quiz")

            }
        }
    }
}
