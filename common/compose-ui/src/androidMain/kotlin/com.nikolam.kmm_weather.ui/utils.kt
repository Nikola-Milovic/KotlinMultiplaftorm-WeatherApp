package com.nikolam.kmm_weather.ui

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

@Composable
actual fun isDarkMode() : Boolean {
    return androidx.compose.foundation.isSystemInDarkTheme()
}

@Composable
actual fun loadWeatherIcon(id : Int) : Painter {
    return painterResource(id)
}

fun hideKeyboard(context: Context) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
}
