package com.nikolam.kmm_weather.common.utils

import io.ktor.client.engine.*

/**
 * Contains some expected dependencies for the [ServiceLocator] that have to be resolved by Android/iOS.
 */
expect object PlatformServiceLocator {
    val httpClientEngine: HttpClientEngine
}