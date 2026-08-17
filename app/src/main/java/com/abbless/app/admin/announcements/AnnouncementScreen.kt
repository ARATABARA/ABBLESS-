package com.abbless.app.admin.announcements

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun AnnouncementScreen() {

    var title by remember {
        mutableStateOf("")
    }

    var message by remember {
        mutableStateOf("")
    }

    var target by remember {
        mutableStateOf("ALL")
    }

    var status by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "📢 Announcements",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            label = {
                Text("Title")
            },
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = message,
            onValueChange = {
                message = it
            },
            label = {
                Text("Message")
            },
            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text("Target: $target")

        Row {

            Button(
                onClick = {
                    target = "ALL"
                }
            ) {
                Text("All Users")
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Button(
                onClick = {
                    target = "STUDENTS"
                }
            ) {
                Text("Students")
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                if (
                    title.isNotBlank() &&
                    message.isNotBlank()
                ) {

                    AnnouncementRepository.publish(

                        Announcement(

                            id =
                                UUID.randomUUID()
                                    .toString(),

                            title = title,

                            message = message,

                            target = target,

                            createdAt =
                                System.currentTimeMillis()
                        )
                    )

                    title = ""
                    message = ""

                    status =
                        "Announcement published ✅"

                } else {

                    status =
                        "Uzuza title na message."
                }
            }
        ) {

            Text("📢 Publish")
        }

        if (status.isNotEmpty()) {

            Spacer(
                modifier =
                    Modifier.height(12.dp)
            )

            Text(status)
        }
    }
}
