package com.abbless.app.core

data class AppState(

    val isLoggedIn: Boolean = false,

    val isOnline: Boolean = true,

    val language: String = "Kirundi",

    val darkMode: Boolean = true

)
