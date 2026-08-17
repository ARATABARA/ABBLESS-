package com.abbless.app.social.profile


data class UserProfile(

    val userId: String,

    val name: String,

    val username: String,

    val bio: String,

    val profileImage: String? = null,

    val level: String,

    val subscription: String

)
