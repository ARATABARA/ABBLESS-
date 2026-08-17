package com.abbless.app.admin.users

data class ManagedUser(

    val id: String,

    val name: String,

    val email: String,

    val active: Boolean = true,

    val isAdmin: Boolean = false

)
