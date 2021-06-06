package com.nikolam.kmm_weather.desktop

import androidx.compose.desktop.DesktopTheme
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.badoo.reaktive.coroutinesinterop.asScheduler
import com.badoo.reaktive.scheduler.overrideSchedulers
import com.nikolam.kmm_weather.common.root.WeatherRoot
import com.nikolam.kmm_weather.common.root.integration.WeatherRootComponent
import com.nikolam.kmm_weather.ui.WeatherRootContent
import kotlinx.coroutines.Dispatchers

fun main() {
    //overrideSchedulers(main = Dispatchers.Main::asScheduler)

    Window("Weather") {
        Surface(modifier = Modifier.fillMaxSize()) {
            MaterialTheme {
                DesktopTheme {
                  WeatherRootContent(rememberRootComponent(factory = ::weatherRoot))
                }
            }
        }
    }
}

private fun weatherRoot(componentContext: ComponentContext): WeatherRoot =
    WeatherRootComponent(
        componentContext = componentContext,
        storeFactory = DefaultStoreFactory
    )
