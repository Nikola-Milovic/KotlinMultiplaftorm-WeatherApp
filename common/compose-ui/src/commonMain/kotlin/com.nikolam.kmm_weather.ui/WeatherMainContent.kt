package com.nikolam.kmm_weather.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.asState
import com.nikolam.kmm_weather.common.main.WeatherItem
import com.nikolam.kmm_weather.common.main.WeatherMain
import com.nikolam.kmm_weather.common.main.integration.WeatherMainComponent

@Composable
fun WeatherMainContent(component: WeatherMain) {
    val model by component.models.asState()
}


@Composable
private fun WeatherList(
    items : List<WeatherItem>
) {
    LazyColumn {
        items.forEach { item ->
           WeatherItem(item.string)
        }
    }
    println(items)
}

@Composable
private fun WeatherItem(
    text : String
) {
    val modifier = Modifier
    modifier.padding(4.dp)
    Text(text = text, modifier)
}