package com.abbless.app.quiz.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abbless.app.quiz.data.QuizRepository

@Composable
fun QuizScreen() {

    val questions = QuizRepository.getQuestions()

    var currentQuestion by remember {
        mutableStateOf(0)
    }

    var score by remember {
        mutableStateOf(0)
    }

    var finished by remember {
        mutableStateOf(false)
    }

    if (finished) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                text = "Quiz yarangiye 🎉",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Score: $score / ${questions.size}"
            )
        }

        return
    }

    val question = questions[currentQuestion]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Question ${currentQuestion + 1}/${questions.size}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = question.question,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        question.options.forEachIndexed { index, option ->

            Button(

                onClick = {

                    if (index == question.correctAnswer) {
                        score++
                    }

                    if (currentQuestion < questions.lastIndex) {
                        currentQuestion++
                    } else {
                        finished = true
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)

            ) {

                Text(option)

            }
        }
    }
}
