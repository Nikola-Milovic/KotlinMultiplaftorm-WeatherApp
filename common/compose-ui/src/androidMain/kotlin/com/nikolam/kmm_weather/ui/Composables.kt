package com.nikolam.kmm_weather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.nikolam.kmm_weather.common.ui.R

@Composable
actual fun isDarkMode(): Boolean {
    return isSystemInDarkTheme()
}

@Composable
actual fun KMPImage(
    id: Int,
    modifier: Modifier,
    colorFilter: ColorFilter?,
    contentDescription: String
) {
    var resId = R.drawable.angry_clouds

    when (id) {
        1 -> {
            resId = R.drawable.ic_water_drop_black_24dp
        }
        2 -> {
            resId = R.drawable.ic_air_black_24dp
        }
        in 200..232 -> {
            resId = R.drawable.thunder
        }
        in 300..321 -> {
            resId = R.drawable.day_rain
        }
        in 500..531 -> {
            resId = R.drawable.rain
        }
        in 600..622 -> {
            resId = R.drawable.snow
        }
        800 -> {
            resId = R.drawable.day_clear
        }
        in 801..804 -> {
            resId = R.drawable.cloudy
        }
        else -> {
            resId = R.drawable.day_clear
        }
    }
    Image(
        painter = painterResource(resId), modifier = modifier,
        contentDescription = contentDescription,
        colorFilter = colorFilter
    )
}