package com.nikolam.kmm_weather.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap


@Composable
expect fun isDarkMode(): Boolean

@Composable
expect fun KMPImage(
    id: Int,
    modifier: Modifier,
    colorFilter: ColorFilter?,
    contentDescription: String
)

//@Composable
//expect fun SearchBox(modifier: Modifier)
