package com.abbless.app.auth.data

import android.content.Context
import com.abbless.app.auth.model.UserAccount
import org.json.JSONArray
import org.json.JSONObject

object AuthRepository {

    private const val PREFS_NAME = "abbless_auth"

    private const val KEY_ACCOUNTS = "accounts"
    private const val KEY_ACTIVE_USER_ID = "active_user_id"

    fun register(
        context: Context,
        user: UserAccount
    ) {

        val prefs = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )

        val accounts = getAllAccounts(context).toMutableList()

        val existing = accounts.any {
            it.phoneNumber.trim() ==
                user.phoneNumber.trim()
        }

        if (!existing) {

            accounts.add(user)

            saveAllAccounts(
                context,
                accounts
            )
        }
    }

    fun login(
        context: Context,
        phoneNumber: String,
        password: String
    ): UserAccount? {

        val user = getAllAccounts(context)
            .firstOrNull {

                it.phoneNumber.trim() ==
                    phoneNumber.trim() &&
                it.password == password
            }

        if (user != null) {

            setActiveUser(
                context,
                user.id
            )

            return user
        }

        return null
    }

    fun getAllAccounts(
        context: Context
    ): List<UserAccount> {

        val prefs = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )

        val json =
            prefs.getString(
                KEY_ACCOUNTS,
                null
            )
                ?: return emptyList()

        return try {

            val array = JSONArray(json)
            val accounts = mutableListOf<UserAccount>()

            for (i in 0 until array.length()) {

                val item =
                    array.getJSONObject(i)

                accounts.add(
                    UserAccount(
                        id = item.optString("id"),
                        name = item.optString("name"),
                        phoneNumber =
                            item.optString(
                                "phoneNumber"
                            ),
                        dateOfBirth =
                            item.optString(
                                "dateOfBirth"
                            ),
                        password =
                            item.optString(
                                "password"
                            )
                    )
                )
            }

            accounts

        } catch (
            e: Exception
        ) {

            emptyList()
        }
    }

    fun getActiveUser(
        context: Context
    ): UserAccount? {

        val prefs = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )

        val activeId =
            prefs.getString(
                KEY_ACTIVE_USER_ID,
                null
            )
                ?: return null

        return getAllAccounts(context)
            .firstOrNull {
                it.id == activeId
            }
    }

    fun getActiveUserId(
        context: Context
    ): String? {

        return context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .getString(
                KEY_ACTIVE_USER_ID,
                null
            )
    }

    private fun setActiveUser(
        context: Context,
        userId: String
    ) {

        context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .putString(
                KEY_ACTIVE_USER_ID,
                userId
            )
            .apply()
    }

    fun logout(
        context: Context
    ) {

        context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .remove(KEY_ACTIVE_USER_ID)
            .apply()
    }

    fun resetPassword(
        context: Context,
        phoneNumber: String,
        dateOfBirth: String,
        newPassword: String
    ): Boolean {

        val accounts =
            getAllAccounts(context).toMutableList()

        val index =
            accounts.indexOfFirst {

                it.phoneNumber.trim() ==
                    phoneNumber.trim() &&
                it.dateOfBirth.trim() ==
                    dateOfBirth.trim()
            }

        if (index == -1) {
            return false
        }

        val oldUser = accounts[index]

        accounts[index] =
            oldUser.copy(
                password = newPassword
            )

        saveAllAccounts(
            context,
            accounts
        )

        return true
    }

    private fun saveAllAccounts(
        context: Context,
        accounts: List<UserAccount>
    ) {

        val array = JSONArray()

        accounts.forEach { user ->

            val item = JSONObject()

            item.put(
                "id",
                user.id
            )

            item.put(
                "name",
                user.name
            )

            item.put(
                "phoneNumber",
                user.phoneNumber
            )

            item.put(
                "dateOfBirth",
                user.dateOfBirth
            )

            item.put(
                "password",
                user.password
            )

            array.put(item)
        }

        context
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .putString(
                KEY_ACCOUNTS,
                array.toString()
            )
            .apply()
    }

}

