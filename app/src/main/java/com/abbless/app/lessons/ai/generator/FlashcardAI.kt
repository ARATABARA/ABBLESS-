package com.abbless.app.lessons.ai.generator


object FlashcardAI {


    fun create(
        topic: String
    ): List<String>{

        return listOf(

            "Definition of $topic",

            "Important points about $topic"

        )

    }

}
