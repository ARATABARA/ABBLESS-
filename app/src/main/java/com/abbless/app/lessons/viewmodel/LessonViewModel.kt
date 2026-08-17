package com.abbless.app.lessons.viewmodel

import androidx.lifecycle.ViewModel
import com.abbless.app.lessons.data.LessonRepository
import com.abbless.app.lessons.model.Lesson

class LessonViewModel : ViewModel(){

    private val allLessons =
        LessonRepository.getLessons()


    fun getLessons(): List<Lesson>{

        return allLessons

    }


    fun getByCategory(
        category: String
    ): List<Lesson>{

        return allLessons.filter {

            it.category == category

        }

    }

}
