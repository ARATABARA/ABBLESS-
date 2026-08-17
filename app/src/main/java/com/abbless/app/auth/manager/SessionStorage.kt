package com.abbless.app.auth.manager

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.sessionDataStore by preferencesDataStore(
    name = "abbless_session"
)

class SessionStorage(
    private val context: Context
) {

    private val userIdKey =
        stringPreferencesKey("user_id")

    suspend fun saveUserId(userId: String) {

        context.sessionDataStore.edit { preferences ->

            preferences[userIdKey] = userId

        }
    }

    suspend fun getUserId(): String? {

        val preferences =
            context.sessionDataStore.data.first()

        return preferences[userIdKey]
    }

    suspend fun clearSession() {

        context.sessionDataStore.edit { preferences ->

            preferences.remove(userIdKey)

        }
    }
}
