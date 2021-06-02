package com.nikolam.kmm_weather.ui

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
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