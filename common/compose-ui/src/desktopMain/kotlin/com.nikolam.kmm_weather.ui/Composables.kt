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
    Image(imageResource("images/day_clear.png"),
        modifier = modifier,
        contentDescription = contentDescription,
        colorFilter = colorFilter
    )
}

//@Composable
//actual fun SearchBox(modifier: Modifier) {
//}