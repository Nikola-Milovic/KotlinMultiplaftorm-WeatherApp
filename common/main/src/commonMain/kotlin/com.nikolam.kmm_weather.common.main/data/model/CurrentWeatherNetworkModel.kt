package com.nikolam.kmm_weather.common.main.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherNetworkModel(
    val lat: Double,
    val lon: Double,
    val timezone: String,

    @SerialName("timezone_offset")
    val timezoneOffset: Long,

    val current: Current,
    val hourly: List<Current>,
    val daily: List<Daily>,
    var alerts: List<Alert> = listOf()
) {
    fun toBusinessModel(): CurrentWeatherModel {
        return CurrentWeatherModel(timezone)
    }
}

@Serializable
data class Alert(
    @SerialName("sender_name")
    val senderName: String,

    val event: String,
    val start: Long,
    val end: Long,
    val description: String
)

@Serializable
data class Current(
    val dt: Long,
    val sunrise: Long? = null,
    val sunset: Long? = null,
    val temp: Double,

    @SerialName("feels_like")
    val feelsLike: Double,

    val pressure: Long,
    val humidity: Long,

    @SerialName("dew_point")
    val dewPoint: Double,

    val uvi: Double,
    val clouds: Long,
    val visibility: Long,

    @SerialName("wind_speed")
    val windSpeed: Double,

    @SerialName("wind_deg")
    val windDeg: Long,

    val weather: List<Weather>,
    val rain: Rain? = null,

    @SerialName("wind_gust")
    val windGust: Double? = null
)

@Serializable
data class Rain(
    @SerialName("1h")
    val the1H: Double
)

@Serializable
data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

@Serializable
data class Daily(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val moonrise: Long,
    val moonset: Long,

    @SerialName("moon_phase")
    val moonPhase: Double,

    val temp: Temp,

    @SerialName("feels_like")
    val feelsLike: FeelsLike,

    val pressure: Long,
    val humidity: Long,

    @SerialName("dew_point")
    val dewPoint: Double,

    @SerialName("wind_speed")
    val windSpeed: Double,

    @SerialName("wind_deg")
    val windDeg: Long,

    val weather: List<Weather>,
    val clouds: Long,
    val pop: Double,
    val rain: Double,
    val uvi: Double
)

@Serializable
data class FeelsLike(
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

@Serializable
data class Temp(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)
