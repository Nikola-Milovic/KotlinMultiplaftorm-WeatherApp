package com.nikolam.kmm_weather.common.main

import com.arkivanov.decompose.value.Value
import com.nikolam.kmm_weather.common.main.data.model.CurrentWeatherModel

interface WeatherMainModel {
    val models : Value<Model>

    fun onItemClicked(id : Long)

    data class Model(
        val currentWeather : CurrentWeatherModel? = null,
        val isLoading : Boolean = true,
        val isError : Boolean = true
    )

    sealed class Output {
        data class SelectedDay(val id : Long) : Output()
    }


}