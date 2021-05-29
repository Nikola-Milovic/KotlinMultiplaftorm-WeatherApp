package com.nikolam.kmm_weather.common.utils

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual object PlatformServiceLocator {
    actual val httpClientEngine: HttpClientEngine by lazy {
        OkHttp.create {
//            val networkInterceptor = HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//            addNetworkInterceptor(networkInterceptor)
//        }
        }
    }
}