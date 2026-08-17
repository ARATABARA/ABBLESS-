package com.abbless.app.ai.teacher


object ExerciseGenerator {


    fun generate(

        topic: String

    ): List<String>{


        return listOf(

            "Explain $topic",

            "Give an example of $topic",

            "Solve an exercise about $topic"

        )

    }


}
