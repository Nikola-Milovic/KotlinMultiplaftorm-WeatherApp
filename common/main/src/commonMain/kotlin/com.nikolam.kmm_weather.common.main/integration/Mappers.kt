package com.nikolam.kmm_weather.common.main.integration

import com.nikolam.kmm_weather.common.main.store.WeatherMainStore
import com.nikolam.kmm_weather.common.main.WeatherMainModel

internal val STATE_TO_MODEL: (WeatherMainStore.State) -> WeatherMainModel.Model =
    {
        WeatherMainModel.Model(
            modelCurrents = it.modelCurrents
        )
    }