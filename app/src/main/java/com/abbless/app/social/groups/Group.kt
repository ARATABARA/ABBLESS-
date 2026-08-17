package com.abbless.app.social.groups


data class Group(

    val id: String,

    val name: String,

    val description: String,

    val adminId: String,

    val image: String? = null

)
