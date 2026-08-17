package com.abbless.app.lessons.offline

data class OfflineLesson(

    val lessonId: String,

    val title: String,

    val filePath: String,

    val type: String,

    val downloaded: Boolean

)
