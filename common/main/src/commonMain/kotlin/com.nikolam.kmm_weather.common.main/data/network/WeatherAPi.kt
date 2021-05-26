package com.nikolam.kmm_weather.common.main.datasource.network

import io.ktor.client.*
import io.ktor.client.engine.*

internal class WeatherAPi(clientEngine: HttpClientEngine) {

    private val client = HttpClient(clientEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getCurrentWeather(): PopularMoviesEntity {
        // Actually we're able to just return the get()-call and Ktor's JsonFeature will automatically do the
        // JSON parsing for us. However, this currently doesn't work with Kotlin/Native as it doesn't support reflection
        // and we have to manually use PopularMoviesEntity.serializer()
        val response = client.get<HttpResponse> {
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_URL
                encodedPath = "/discover/movie"
                parameter("sort_by", "popularity.desc")
                header(HEADER_AUTHORIZATION, API_KEY.asBearerToken())
            }
        }

        val jsonBody = response.readText()
        return Json.parse(PopularMoviesEntity.serializer(), jsonBody)
    }


}