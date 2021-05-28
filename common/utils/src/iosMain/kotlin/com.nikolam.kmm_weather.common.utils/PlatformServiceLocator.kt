package com.nikolam.kmm_weather.common.utils

import io.ktor.client.engine.*
import io.ktor.client.engine.ios.*

actual object PlatformServiceLocator {
   actual val httpClientEngine: HttpClientEngine = Ios.create()
}