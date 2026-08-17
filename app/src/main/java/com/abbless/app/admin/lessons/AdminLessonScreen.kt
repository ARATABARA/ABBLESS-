package com.abbless.app.admin.lessons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun AdminLessonScreen() {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var category by remember {
        mutableStateOf("")
    }

    var language by remember {
        mutableStateOf("Kirundi")
    }

    var videoUrl by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "📚 Lesson Manager",
            style = MaterialTheme.typography.headlineMedium
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
                Text("Lesson title")
            }
        )

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },
            label = {
                Text("Description")
            }
        )

        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
            },
            label = {
                Text("Category")
            }
        )

        OutlinedTextField(
            value = language,
            onValueChange = {
                language = it
            },
            label = {
                Text("Language")
            }
        )

        OutlinedTextField(
            value = videoUrl,
            onValueChange = {
                videoUrl = it
            },
            label = {
                Text("Video URL")
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                AdminLessonRepository.addLesson(

                    AdminLesson(

                        id =
                            UUID.randomUUID()
                                .toString(),

                        title = title,

                        description =
                            description,

                        category = category,

                        language = language,

                        videoUrl =
                            videoUrl.ifBlank {
                                null
                            },

                        published = true
                    )
                )

                title = ""
                description = ""
                category = ""
                videoUrl = ""
            }
        ) {

            Text("➕ Add Lesson")
        }
    }
}
