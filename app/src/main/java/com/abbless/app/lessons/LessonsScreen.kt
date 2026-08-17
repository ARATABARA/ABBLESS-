package com.abbless.app.lessons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LessonsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "📚 ABBLESS Lessons",
            style = MaterialTheme.typography.headlineMedium
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        LessonCard(
            "Science",
            "Physics, Biology, Chemistry"
        )


        LessonCard(
            "Technology",
            "Programming & AI"
        )


        LessonCard(
            "Languages",
            "English, French, Kirundi"
        )


        LessonCard(
            "Business",
            "Economics & Entrepreneurship"
        )

    }

}



@Composable
fun LessonCard(
    title: String,
    description: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = description
            )

        }

    }

}
