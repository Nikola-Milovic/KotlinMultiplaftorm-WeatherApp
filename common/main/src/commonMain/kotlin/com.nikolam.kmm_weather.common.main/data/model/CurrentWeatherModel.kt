package com.nikolam.kmm_weather.common.main.data.model

data class CurrentWeatherModel(val weatherID : Int, val daily : List<DailyWeatherModel>, val temp: Int, val wind : Int, val humidity : Int, val weatherDesc : String
)
data class DailyWeatherModel(val weatherID : Int, val index : Int, val temp: Int)