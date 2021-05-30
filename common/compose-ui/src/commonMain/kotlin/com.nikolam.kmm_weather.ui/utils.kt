package com.nikolam.kmm_weather.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import kotlin.math.roundToInt

@Composable
expect fun isSystemInDarkTheme() : Boolean

expect fun loadWeatherIcon(id : Int) : Painter

fun String.toTempUnit(unit : String) : String{
    return if (unit == "C") "$this°"
    else (this.toInt() * 1.8f + 32).roundToInt().toString() +"F"
}

@Composable
expect fun SearchBox(modifier: Modifier)