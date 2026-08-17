package com.abbless.app.core

object SessionManager {

    private var loggedIn = false

    private var currentUserId = ""

    fun login(userId: String) {
        loggedIn = true
        currentUserId = userId
    }

    fun logout() {
        loggedIn = false
        currentUserId = ""
    }

    fun isLoggedIn(): Boolean = loggedIn

    fun getUserId(): String = currentUserId
}
