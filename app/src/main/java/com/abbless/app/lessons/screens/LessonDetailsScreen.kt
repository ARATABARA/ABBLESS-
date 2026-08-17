package com.abbless.app.lessons.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LessonDetailsScreen(){

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ){

        Text(
            text = "Lesson Details",
            style = MaterialTheme.typography.headlineMedium
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        Button(
            onClick = {}
        ){
            Text("🎥 Watch Video")
        }


        Button(
            onClick = {}
        ){
            Text("📄 Open PDF")
        }


        Button(
            onClick = {}
        ){
            Text("🧩 Start Quiz")
        }


    }

}
