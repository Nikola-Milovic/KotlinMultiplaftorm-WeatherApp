package com.nikolam.kmm_weather.common.main.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CurrentWeatherNetworkModel (
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long
) {
}
@Serializable
internal data class Clouds (
    val all: Long
)
@Serializable
internal data class Coord (
    val lon: Float,
    val lat: Float
)
@Serializable
internal data class Main (
    val temp: Float,

    @SerialName("feels_like")
    val feelsLike: Float,

    @SerialName( "temp_min")
    val tempMin: Float,

    @SerialName("temp_max")
    val tempMax: Float,

    val pressure: Long,
    val humidity: Long
)
@Serializable
internal data class Sys (
    val type: Long,
    val id: Long,
    val message: Float,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
@Serializable
internal data class Weather (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)
@Serializable
internal data class Wind (
    val speed: Float,
    val deg: Long
)

