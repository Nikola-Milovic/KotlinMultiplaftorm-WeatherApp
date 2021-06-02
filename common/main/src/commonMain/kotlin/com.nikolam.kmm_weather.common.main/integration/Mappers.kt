package com.nikolam.kmm_weather.common.main.integration

import com.nikolam.kmm_weather.common.main.store.WeatherMainStore
import com.nikolam.kmm_weather.common.main.WeatherMainModel

internal val STATE_TO_MODEL: (WeatherMainStore.State) -> WeatherMainModel.Model =
    {
        WeatherMainModel.Model(
            currentWeather = it.currentWeather,
            isError = it.isError,
            isLoading =  it.isLoading
        )
    }