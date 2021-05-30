package com.nikolam.kmm_weather.common.main.data.network

import com.nikolam.kmm_weather.common.main.data.model.CurrentWeatherModel
import com.nikolam.kmm_weather.common.main.data.model.CurrentWeatherNetworkModel
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import io.github.aakira.napier.Napier

class WeatherAPI(clientEngine: HttpClientEngine) {

    private val client = HttpClient(clientEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getWeather(): CurrentWeatherModel {
        // Actually we're able to just return the get()-call and Ktor's JsonFeature will automatically do the
        // JSON parsing for us. However, this currently doesn't work with Kotlin/Native as it doesn't support reflection
        // and we have to manually use PopularMoviesEntity.serializer()
        val response = client.get<HttpResponse> {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.openweathermap.org/"
                encodedPath = "/data/2.5/onecall"
                //    parameter("q", "Belgrade")
                parameter("appid", "f3a39ee4cb7053b4b27f3bbb8bca11c8")
                parameter("units", "metric")
                parameter("lat", 44.787197)
                parameter("lon", 20.457273)
//                header(HEADER_AUTHORIZATION, API_KEY.asBearerToken())
            }
        }

        val jsonBody = response.readText()
        val netModel = Json {
            ignoreUnknownKeys = true
        }.decodeFromString(CurrentWeatherNetworkModel.serializer(), jsonBody)

        Napier.d(netModel.toString(), tag = "my_tag")


        return netModel.toBusinessModel()
    }
}