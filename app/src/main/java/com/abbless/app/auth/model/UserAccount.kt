package com.abbless.app.auth.model

data class UserAccount(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val dateOfBirth: String,
    val password: String
)

