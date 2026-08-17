package com.abbless.app.admin.auth

import android.content.Context
import android.util.Base64

object AdminSecureStorage {

    private const val PREFS = "abbless_admin_security"

    private const val HASH_KEY = "password_hash"
    private const val SALT_KEY = "password_salt"

    fun savePasswordHash(
        context: Context,
        hash: ByteArray,
        salt: ByteArray
    ) {

        context
            .getSharedPreferences(
                PREFS,
                Context.MODE_PRIVATE
            )
            .edit()
            .putString(
                HASH_KEY,
                Base64.encodeToString(
                    hash,
                    Base64.NO_WRAP
                )
            )
            .putString(
                SALT_KEY,
                Base64.encodeToString(
                    salt,
                    Base64.NO_WRAP
                )
            )
            .apply()
    }

    fun getPasswordHash(
        context: Context
    ): ByteArray? {

        val value =
            context
                .getSharedPreferences(
                    PREFS,
                    Context.MODE_PRIVATE
                )
                .getString(
                    HASH_KEY,
                    null
                )
                ?: return null

        return Base64.decode(
            value,
            Base64.NO_WRAP
        )
    }

    fun getPasswordSalt(
        context: Context
    ): ByteArray? {

        val value =
            context
                .getSharedPreferences(
                    PREFS,
                    Context.MODE_PRIVATE
                )
                .getString(
                    SALT_KEY,
                    null
                )
                ?: return null

        return Base64.decode(
            value,
            Base64.NO_WRAP
        )
    }
}

