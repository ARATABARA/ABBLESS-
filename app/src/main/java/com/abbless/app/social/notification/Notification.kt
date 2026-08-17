package com.abbless.app.social.notification


data class Notification(

    val id: String,

    val userId: String,

    val title: String,

    val message: String,

    val time: Long,

    val read: Boolean = false

)
