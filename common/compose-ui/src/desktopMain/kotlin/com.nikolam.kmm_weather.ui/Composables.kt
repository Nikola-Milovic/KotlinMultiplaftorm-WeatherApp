package com.nikolam.kmm_weather.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.imageResource

@Composable
actual fun isDarkMode(): Boolean {
    return false //isSystemInDarkTheme()
}

@Composable
actual fun KMPImage(
    id: Int,
    modifier: Modifier,
    colorFilter: ColorFilter?,
    contentDescription: String
) {

    var fileName = "images/day_clear.png"

    when (id) {
        1 -> {
            fileName = "images/water_drop.png"
        }
        2 -> {
            fileName = "images/air.png"
        }
        in 200..232 -> {
            fileName = "images/thunder.png"
        }
        in 300..321 -> {
            fileName = "images/day_rain.png"
        }
        in 500..531 -> {
            fileName = "images/rain.png"
        }
        in 600..622 -> {
            fileName = "images/snow.png"
        }
        800 -> {
            fileName = "images/day_clear.png"
        }
        in 801..804 -> {
            fileName = "images/cloudy.png"
        }
        else -> {
            fileName = "images/day_clear.png"
        }
    }

    Image(imageResource(fileName),
        modifier = modifier,
        contentDescription = contentDescription,
        colorFilter = colorFilter
    )
}

//@Composable
//actual fun SearchBox(modifier: Modifier) {
//}