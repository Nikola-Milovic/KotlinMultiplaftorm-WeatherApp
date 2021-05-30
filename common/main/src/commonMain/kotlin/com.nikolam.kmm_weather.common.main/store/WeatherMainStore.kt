package com.nikolam.kmm_weather.common.main.store

import com.arkivanov.mvikotlin.core.store.Store
import com.nikolam.kmm_weather.common.main.data.model.CurrentWeatherModel


internal interface WeatherMainStore : Store<WeatherMainStore.Intent, WeatherMainStore.State, Nothing> {

    sealed class Intent {
    }

    data class State(
        val currentWeather : CurrentWeatherModel? = null,
        val isLoading : Boolean = true,
        val isError : Boolean = true
    )
}