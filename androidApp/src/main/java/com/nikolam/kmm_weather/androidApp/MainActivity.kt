package com.nikolam.kmm_weather.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.toArgb
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.arkivanov.mvikotlin.timetravel.store.TimeTravelStoreFactory
import com.nikolam.kmm_weather.common.root.WeatherRoot
import com.nikolam.kmm_weather.common.root.integration.WeatherRootComponent
import com.nikolam.kmm_weather.ui.WeatherRootContent
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Napier.base(DebugAntilog("my_weather_tag"))
        setContent {
            ComposeAppTheme {
                if (!isSystemInDarkTheme()) {
                    window.statusBarColor = DarkPurple.toArgb()
                } else {
                    window.statusBarColor = DarkDarkPurple.toArgb()
                }

                Surface(color = MaterialTheme.colors.background) {
                    WeatherRootContent(rememberRootComponent(::weatherRoot))
                }
            }
        }
    }

    private fun weatherRoot(componentContext: ComponentContext): WeatherRoot =
        WeatherRootComponent(
            componentContext = componentContext,
            storeFactory = LoggingStoreFactory(TimeTravelStoreFactory(DefaultStoreFactory))
        )
}
