package com.nikolam.kmm_weather.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
actual fun isDarkMode() : Boolean {
    return false //isSystemInDarkTheme()
}
@Composable
actual fun loadWeatherIcon(id : Int) : Painter {
    return loadWeatherIcon(id)
}
@Composable
actual fun SearchBox(modifier: Modifier) {}