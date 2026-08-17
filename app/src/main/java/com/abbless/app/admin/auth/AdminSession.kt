package com.abbless.app.admin.auth

object AdminSession {

    private var loggedIn = false
    private var role: UserRole? = null

    fun loginAsAdmin() {
        loggedIn = true
        role = UserRole.ADMIN
    }

    fun logout() {
        loggedIn = false
        role = null
    }

    fun isAdmin(): Boolean {
        return loggedIn &&
                AdminAccessGuard.canAccessAdminPanel(
                    role ?: UserRole.USER
                )
    }
}


