package com.nikolam.kmm_weather.ui

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager


fun hideKeyboard(context: Context) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
}
