package com.abbless.app.admin.auth

object AdminAuthRepository {

    private const val ADMIN_USERNAME = "admin"

    // Iyi ni temporary password.
    // Tuzoyihindura tukoreshe secure storage mu ntambwe ikurikira.
    private var adminPassword = "ABBLESS@2026"

    fun login(
        username: String,
        password: String
    ): Boolean {

        return username == ADMIN_USERNAME &&
                password == adminPassword
    }

    fun changePassword(
        oldPassword: String,
        newPassword: String
    ): Boolean {

        if (oldPassword != adminPassword) {
            return false
        }

        if (newPassword.length < 8) {
            return false
        }

        adminPassword = newPassword

        return true
    }
}
