package com.abbless.app.admin.announcements

data class Announcement(

    val id: String,

    val title: String,

    val message: String,

    val target: String,

    val createdAt: Long

)
