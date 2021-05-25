package com.nikolam.kmm_weather.common.main.store

import com.arkivanov.mvikotlin.core.store.Store
import com.nikolam.kmm_weather.common.main.WeatherItem

internal interface WeatherMainStore : Store<WeatherMainStore.Intent, WeatherMainStore.State, Nothing> {

    sealed class Intent {
    }

    data class State(
        val items : List<WeatherItem> = emptyList()
    )
}