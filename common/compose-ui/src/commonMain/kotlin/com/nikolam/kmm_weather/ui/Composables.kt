package com.nikolam.kmm_weather.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import kotlin.math.roundToInt

@Composable
expect fun isDarkMode() : Boolean

@Composable
expect fun loadWeatherIcon(id : Int) : Painter

@Composable
expect fun SearchBox(modifier: Modifier)
