package com.abbless.app.admin.lessons

object AdminLessonRepository {

    private val lessons =
        mutableListOf<AdminLesson>()

    fun addLesson(
        lesson: AdminLesson
    ) {
        lessons.add(lesson)
    }

    fun getLessons(): List<AdminLesson> {
        return lessons
    }

    fun deleteLesson(
        id: String
    ) {
        lessons.removeAll {
            it.id == id
        }
    }

    fun updateLesson(
        lesson: AdminLesson
    ) {

        val index = lessons.indexOfFirst {
            it.id == lesson.id
        }

        if (index != -1) {
            lessons[index] = lesson
        }
    }
}
