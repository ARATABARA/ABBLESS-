package com.abbless.app.lessons.ai.generator


data class GeneratedLesson(

    val title: String,

    val summary: String,

    val questions: List<String>,

    val flashcards: List<String>

)


object LessonGenerator {


    fun generate(

        text: String

    ): GeneratedLesson {


        return GeneratedLesson(

            title = "Generated Lesson",

            summary = text.take(200),

            questions = listOf(
                "What is the main idea?",
                "Explain this topic."
            ),

            flashcards = listOf(
                "Key concept"
            )

        )

    }

}
