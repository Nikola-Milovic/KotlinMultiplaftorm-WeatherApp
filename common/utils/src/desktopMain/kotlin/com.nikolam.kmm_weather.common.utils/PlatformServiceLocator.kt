package com.nikolam.kmm_weather.common.utils
import io.ktor.client.engine.*

actual object PlatformServiceLocator {
   actual val httpClientEngine: HttpClientEngine get() = throw NotImplementedError()
}