package com.abbless.app.admin.lessons

data class AdminLesson(

    val id: String,

    val title: String,

    val description: String,

    val category: String,

    val language: String,

    val videoUrl: String? = null,

    val published: Boolean = false

)
