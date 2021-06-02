package com.nikolam.kmm_weather.ui

import kotlin.math.roundToInt

fun String.toTempUnit(unit : String) : String{
    return if (unit == "C") "$this°"
    else (this.toInt() * 1.8f + 32).roundToInt().toString() +"F"
}