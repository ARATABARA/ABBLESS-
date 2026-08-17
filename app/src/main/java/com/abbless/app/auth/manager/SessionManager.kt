package com.abbless.app.auth.manager

object SessionManager {

    private var currentUserId: String? = null

    fun login(userId: String) {
        currentUserId = userId
    }

    fun isLoggedIn(): Boolean {
        return currentUserId != null
    }

    fun getUserId(): String? {
        return currentUserId
    }

    fun logout() {
        currentUserId = null
    }
}
