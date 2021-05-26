package com.nikolam.kmm_weather.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherMainContent(component: WeatherMain) {
    val model by component.models.asState()

    Column {
        Box(Modifier.weight(1F)) {
            WeatherList(
                items = model.items,
            )
        }

    }
}


@Composable
private fun WeatherList(
    items: List<WeatherItem>
) {
    Box {
        LazyColumn(Modifier.fillMaxWidth()) {
            items(items) { item ->
                com.nikolam.kmm_weather.ui.WeatherItem(item.string)
            }
        }
    }
}

@Composable
private fun WeatherItem(
    text: String
) {
    val modifier = Modifier
    modifier.padding(4.dp)
    Text(text = text, modifier)
}