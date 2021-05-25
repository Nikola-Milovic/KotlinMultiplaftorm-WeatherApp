package com.nikolam.kmm_weather.androidApp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.arkivanov.mvikotlin.timetravel.store.TimeTravelStoreFactory
import com.nikolam.kmm_weather.common.root.WeatherRoot
import com.nikolam.kmm_weather.common.root.integration.WeatherRootComponent
import com.nikolam.kmm_weather.ui.WeatherRootContent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAppTheme {
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
