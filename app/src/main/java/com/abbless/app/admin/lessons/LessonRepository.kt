package com.abbless.app.admin.lessons

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class LessonRepository {

    private val lessons = MutableStateFlow(
        listOf(
            AdminLesson(
                id = 1,
                title = "Science",
                category = "Science",
                description = "Lesson ya Science"
            ),
            AdminLesson(
                id = 2,
                title = "Economics",
                category = "Economics",
                description = "Lesson ya Economics"
            )
        )
    )

    fun getLessons(): Flow<List<AdminLesson>> {
        return lessons
    }

    fun addLesson(
        title: String,
        category: String,
        description: String
    ) {

        val newId =
            (lessons.value.maxOfOrNull { it.id } ?: 0) + 1

        lessons.value = lessons.value + AdminLesson(
            id = newId,
            title = title,
            category = category,
            description = description
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
        id: Long
    ) {

        lessons.value =
            lessons.value.filter {
                it.id != id
            }
    }
}

