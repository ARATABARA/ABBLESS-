package com.abbless.app.admin.security

object AdminSecurity {

    private var passwordChanged = false

    fun hasPasswordChanged(): Boolean {
        return passwordChanged
    }

    fun changePassword(
        oldPassword: String,
        newPassword: String
    ): Boolean {

        if (oldPassword.isBlank()) {
            return false
        }

        if (newPassword.length < 8) {
            return false
        }

        passwordChanged = true

        return true
    }
}
