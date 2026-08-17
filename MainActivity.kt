package com.abbless.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abbless.app.core.navigation.AppNavigation
import com.abbless.app.ui.theme.ABBLESSTTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        setContent {

            ABBLESSTTheme {

                AppNavigation()

            }
        }
    }
}

