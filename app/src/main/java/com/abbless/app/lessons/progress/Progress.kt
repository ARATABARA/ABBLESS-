package com.abbless.app.lessons.progress

data class Progress(

    val userId: String,

    val lessonId: String,

    val completed: Boolean,

    val percentage: Int

)
