package com.abbless.app.social.model


data class User(

    val id: String,

    val name: String,

    val email: String,

    val profileImage: String? = null,

    val online: Boolean = false

)
