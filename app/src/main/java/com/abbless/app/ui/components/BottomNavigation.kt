package com.abbless.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomItem(
    val title: String,
    val icon: ImageVector
)


@Composable
fun ABBLESSBottomNavigation(
    onNavigate: (String) -> Unit
) {

    val items = listOf(

        BottomItem(
            "Home",
            Icons.Default.Home
        ),

        BottomItem(
            "Lessons",
            Icons.Default.MenuBook
        ),

        BottomItem(
            "AI",
            Icons.Default.SmartToy
        ),

        BottomItem(
            "Chat",
            Icons.Default.Chat
        ),

        BottomItem(
            "Profile",
            Icons.Default.Person
        )

    )


    NavigationBar {

        items.forEach { item ->

            NavigationBarItem(

                selected = false,

                onClick = {
                    onNavigate(item.title)
                },

                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title
                    )
                },

                label = {
                    Text(item.title)
                }

            )

        }

    }

}
