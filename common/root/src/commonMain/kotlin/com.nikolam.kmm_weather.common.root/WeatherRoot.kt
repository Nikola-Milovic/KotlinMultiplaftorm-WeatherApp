package com.nikolam.kmm_weather.common.root

import com.arkivanov.decompose.RouterState
import com.arkivanov.decompose.value.Value
import com.nikolam.kmm_weather.common.main.WeatherMainModel

interface WeatherRoot {
    val routerState : Value<RouterState<*, Child>>

    sealed class Child {
        data class Main(val component: WeatherMainModel) : Child()
    }
}