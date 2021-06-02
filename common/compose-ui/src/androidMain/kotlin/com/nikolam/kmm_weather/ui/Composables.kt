package com.nikolam.kmm_weather.ui

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.nikolam.kmm_weather.common.ui.R

@Composable
actual fun isDarkMode() : Boolean {
    return isSystemInDarkTheme()
}

@Composable
actual fun loadWeatherIcon(id : Int) : Painter {
    var resId = R.drawable.angry_clouds

    if(id == 1){
        resId = R.drawable.ic_water_drop_black_24dp
    } else if (id == 2) {
        resId = R.drawable.ic_air_black_24dp
    } else if (id in 200..232){
        resId = R.drawable.thunder
    } else if(id in 300..321) {
        resId = R.drawable.day_rain
    } else if (id in 500..531) {
        resId = R.drawable.rain
    } else if (id in 600..622){
        resId = R.drawable.snow
    } else if(id == 800){
        resId = R.drawable.day_clear
    } else if (id in 801..804){
        resId = R.drawable.cloudy
    } else {
        resId = R.drawable.day_clear
    }
    return painterResource(resId)
}