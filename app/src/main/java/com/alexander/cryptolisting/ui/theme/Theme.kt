package com.alexander.cryptolisting.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = ColorPrimary,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = DarkGray
)

private val LightColorPalette = lightColorScheme(
    primary = ColorPrimary,
    background = Color.White,
    onBackground = MediumGray,
    onPrimary = DarkGray
)

@Composable
fun CryptoListingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}