package com.abbless.app.lessons.data

import com.abbless.app.lessons.model.Lesson

object LessonRepository {

    fun getLessons(): List<Lesson> {

        return listOf(

            Lesson(
                id = "1",
                title = "Introduction to Science",
                description = "Learn basics of Physics, Biology and Chemistry",
                category = "Science"
            ),

            Lesson(
                id = "2",
                title = "Programming Basics",
                description = "Learn coding and computer science",
                category = "Technology"
            ),

            Lesson(
                id = "3",
                title = "English Language",
                description = "Improve English communication",
                category = "Languages"
            ),

            Lesson(
                id = "4",
                title = "Economics",
                description = "Learn business and economy",
                category = "Business"
            )

        )

    }

}
