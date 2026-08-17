package com.abbless.app.lessons.ai.generator


object QuizCreatorAI {


    fun createQuiz(
        topic: String
    ): List<String>{

        return listOf(

            "What is $topic?",

            "Give an example of $topic."

        )

    }

}
