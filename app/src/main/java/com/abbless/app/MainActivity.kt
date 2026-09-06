package com.abbless.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.abbless.app.core.navigation.AppNavigation
import com.abbless.app.ui.theme.ABBLESSTTheme

class MainActivity : ComponentActivity() {

    private val darkModeState =
        mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val preferences =
            getSharedPreferences(
                "abbless_settings",
                MODE_PRIVATE
            )

        darkModeState.value =
            preferences.getBoolean(
                "dark_mode",
                true
            )

        setContent {

            var darkMode by darkModeState

            ABBLESSTTheme(
                darkMode = darkMode
            ) {

                AppNavigation(
                    darkMode = darkMode,
                    onDarkModeChange = { enabled ->

                        darkMode = enabled

                        preferences
                            .edit()
                            .putBoolean(
                                "dark_mode",
                                enabled
                            )
                            .apply()
                    }
                )
            }
        }
    }
}
