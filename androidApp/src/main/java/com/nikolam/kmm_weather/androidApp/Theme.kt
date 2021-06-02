package com.nikolam.kmm_weather.androidApp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColors(
    primary = DarkDarkPurple,
    primaryVariant = DarkMediumPurple,
    secondary = DarkSkyBlue,
    onPrimary = DarkTextColor,
    onSecondary = DarkTextColor
)

private val LightColorPalette = lightColors(
    primary = DarkPurple,
    primaryVariant = MediumPurple,
    secondary = SkyBlue,
    onPrimary = Color.White,
    onSecondary = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
