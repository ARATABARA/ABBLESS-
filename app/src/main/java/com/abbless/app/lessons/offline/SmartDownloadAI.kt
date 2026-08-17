package com.abbless.app.lessons.offline

import com.abbless.app.lessons.model.Lesson


object SmartDownloadAI {


    fun recommend(

        lessons: List<Lesson>

    ): List<Lesson>{


        return lessons.take(3)

    }


}
