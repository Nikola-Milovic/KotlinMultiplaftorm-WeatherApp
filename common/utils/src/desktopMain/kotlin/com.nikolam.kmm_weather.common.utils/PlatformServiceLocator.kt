package com.nikolam.kmm_weather.common.utils

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.java.*

actual object PlatformServiceLocator {
    actual val httpClientEngine: HttpClientEngine = Java.create() {
        // this: JavaHttpConfig
        threadsCount = 8
        pipelining = true
    }
}