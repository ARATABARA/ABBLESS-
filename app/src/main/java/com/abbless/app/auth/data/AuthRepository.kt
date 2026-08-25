package com.abbless.app.auth.data

import android.content.Context
import com.abbless.app.auth.model.UserAccount

object AuthRepository {

    private const val PREFS_NAME = "abbless_auth"
    private const val KEY_ID = "user_id"
    private const val KEY_NAME = "user_name"
    private const val KEY_EMAIL = "user_email"
    private const val KEY_PASSWORD = "user_password"

    fun register(
        context: Context,
        user: UserAccount
    ) {
        context
            .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_ID, user.id)
            .putString(KEY_NAME, user.name)
            .putString(KEY_EMAIL, user.email)
            .putString(KEY_PASSWORD, user.password)
            .apply()
    }

    fun login(
        context: Context,
        email: String,
        password: String
    ): UserAccount? {

        val prefs = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )

        val savedEmail = prefs.getString(KEY_EMAIL, null)
        val savedPassword = prefs.getString(KEY_PASSWORD, null)

        if (
            savedEmail == email.trim() &&
            savedPassword == password
        ) {
            return UserAccount(
                id = prefs.getString(KEY_ID, "") ?: "",
                name = prefs.getString(KEY_NAME, "") ?: "",
                email = savedEmail ?: "",
                password = savedPassword ?: ""
            )
        }

        return null
    }
}
