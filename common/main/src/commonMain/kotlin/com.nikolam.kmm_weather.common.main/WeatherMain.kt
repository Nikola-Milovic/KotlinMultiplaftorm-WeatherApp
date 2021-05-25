package com.nikolam.kmm_weather.common.main

import com.arkivanov.decompose.value.Value


interface WeatherMain {
    val models : Value<Model>

    fun onItemClicked(id : Long)

    data class Model(
        val items: List<WeatherItem>
    )

    sealed class Output {
        data class SelectedDay(val id : Long) : Output()
    }


}