package com.abbless.app.admin.lessons

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class LessonRepository {

    private val lessons = MutableStateFlow(
        listOf(
            AdminLesson(
                id = "1",
                title = "Science",
                category = "Science",
                description = "Lesson ya Science",
                language = "Kirundi"
            ),
            AdminLesson(
                id = "2",
                title = "Economics",
                category = "Economics",
                description = "Lesson ya Economics",
                language = "Kirundi"
            )
        )
    )

    fun getLessons(): Flow<List<AdminLesson>> {
        return lessons
    }

    fun addLesson(
        title: String,
        category: String,
        description: String,
        language: String
    ) {
        val newId =
            System.currentTimeMillis().toString()

        lessons.value =
            lessons.value + AdminLesson(
                id = newId,
                title = title,
                category = category,
                description = description,
                language = language
            )
    }

    fun updateLesson(
        lesson: AdminLesson
    ) {
        lessons.value =
            lessons.value.map {
                if (it.id == lesson.id) {
                    lesson
                } else {
                    it
                }
            }
    }

    fun deleteLesson(
        id: String
    ) {
        lessons.value =
            lessons.value.filter {
                it.id != id
            }
    }
}
