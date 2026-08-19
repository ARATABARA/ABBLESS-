package com.abbless.app.admin.auth

import android.content.Context
import java.security.MessageDigest
import java.security.SecureRandom
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

object AdminAuthRepository {

    private const val ADMIN_USERNAME = "admin"

    private const val ITERATIONS = 120_000
    private const val KEY_LENGTH = 256

    fun initialize(context: Context) {

        if (
            AdminSecureStorage
                .getPasswordHash(context) == null
        ) {

            createPassword(
                context,
                "ABBLESS@2026"
            )
        }
    }

    fun login(
        context: Context,
        username: String,
        password: String
    ): Boolean {

        if (username != ADMIN_USERNAME) {
            return false
        }

        val savedHash =
            AdminSecureStorage
                .getPasswordHash(context)
                ?: return false

        val savedSalt =
            AdminSecureStorage
                .getPasswordSalt(context)
                ?: return false

        val enteredHash =
            hashPassword(
                password,
                savedSalt
            )

        return MessageDigest.isEqual(
            enteredHash,
            savedHash
        )
    }

    fun changePassword(
        context: Context,
        oldPassword: String,
        newPassword: String
    ): Boolean {

        if (
            newPassword.length < 8
        ) {
            return false
        }

        if (
            !login(
                context,
                ADMIN_USERNAME,
                oldPassword
            )
        ) {
            return false
        }

        createPassword(
            context,
            newPassword
        )

        return true
    }

    private fun createPassword(
        context: Context,
        password: String
    ) {

        val salt =
            ByteArray(16)

        SecureRandom()
            .nextBytes(salt)

        val hash =
            hashPassword(
                password,
                salt
            )

        AdminSecureStorage
            .savePasswordHash(
                context,
                hash,
                salt
            )
    }

    private fun hashPassword(
        password: String,
        salt: ByteArray
    ): ByteArray {

        val spec =
            PBEKeySpec(
                password.toCharArray(),
                salt,
                ITERATIONS,
                KEY_LENGTH
            )

        val factory =
            SecretKeyFactory
                .getInstance(
                    "PBKDF2WithHmacSHA256"
                )

        return factory
            .generateSecret(spec)
            .encoded
    }
}

