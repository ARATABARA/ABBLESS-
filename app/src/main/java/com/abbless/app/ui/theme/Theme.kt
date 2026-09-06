package com.abbless.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = ABBLESSGreen,
    secondary = ABBLESSBlue,
    tertiary = ABBLESSViolet,
    background = ABBLESSBlack,
    surface = ABBLESSBlack,
    onPrimary = ABBLESSBlack,
    onSecondary = ABBLESSWhite,
    onTertiary = ABBLESSWhite,
    onBackground = ABBLESSWhite,
    onSurface = ABBLESSWhite
)

private val LightColorScheme = lightColorScheme(
    primary = ABBLESSGreen,
    secondary = ABBLESSBlue,
    tertiary = ABBLESSViolet,
    background = ABBLESSWhite,
    surface = ABBLESSWhite,
    onPrimary = ABBLESSBlack,
    onSecondary = ABBLESSWhite,
    onTertiary = ABBLESSWhite,
    onBackground = ABBLESSBlack,
    onSurface = ABBLESSBlack
)

@Composable
fun ABBLESSTTheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme =
        if (darkMode) {
            DarkColorScheme
        } else {
            LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
