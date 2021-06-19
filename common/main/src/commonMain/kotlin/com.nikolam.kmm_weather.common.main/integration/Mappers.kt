package com.nikolam.kmm_weather.common.main.integration

import com.nikolam.kmm_weather.common.main.store.WeatherMainStore
import com.nikolam.kmm_weather.common.main.WeatherMain

internal val STATE_TO: (WeatherMainStore.State) -> WeatherMain.Model =
    {
        WeatherMain.Model(
            currentWeather = it.currentWeather,
            isError = it.isError,
            isLoading =  it.isLoading
        )
    }