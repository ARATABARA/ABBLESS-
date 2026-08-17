package com.abbless.app.quiz.data

import com.abbless.app.quiz.model.QuizQuestion

object QuizRepository {

    fun getQuestions(): List<QuizQuestion> {

        return listOf(

            QuizQuestion(
                id = "1",
                question = "2 + 2 = ?",
                options = listOf(
                    "3",
                    "4",
                    "5",
                    "6"
                ),
                correctAnswer = 1
            ),

            QuizQuestion(
                id = "2",
                question = "Capital y'Uburundi ni iyihe?",
                options = listOf(
                    "Gitega",
                    "Bujumbura",
                    "Ngozi",
                    "Rumonge"
                ),
                correctAnswer = 0
            )

        )
    }
}
