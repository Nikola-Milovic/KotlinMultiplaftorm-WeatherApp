package com.nikolam.kmm_weather.common.main.integration

import com.nikolam.kmm_weather.common.main.store.WeatherMainStore
import com.nikolam.kmm_weather.common.main.WeatherMain

internal val stateToModel: (WeatherMainStore.State) -> WeatherMain.Model =
    {
        WeatherMain.Model(
            items = it.items
        )
    }