package com.abbless.app.admin.auth

enum class UserRole {
    USER,
    ADMIN
}

object AdminAccessGuard {

    fun canAccessAdminPanel(
        role: UserRole
    ): Boolean {
        return role == UserRole.ADMIN
    }
}

