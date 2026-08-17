package com.abbless.app.lessons.model

data class Lesson(

    val id: String,

    val title: String,

    val description: String,

    val category: String,

    val videoUrl: String? = null,

    val pdfUrl: String? = null,

    val completed: Boolean = false

)
