@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.nikolam.kmm_weather.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.nikolam.kmm_weather.common.root.WeatherRoot

@Composable
fun WeatherRootContent(component: WeatherRoot) {
    Children(routerState = component.routerState, animation = crossfadeScale()) {
        when (val child = it.instance) {
            is WeatherRoot.Child.Main -> WeatherMainContent(child.component)
        }
    }
}
