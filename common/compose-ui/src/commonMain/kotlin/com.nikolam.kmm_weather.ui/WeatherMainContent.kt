package com.nikolam.kmm_weather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.arkivanov.decompose.extensions.compose.jetbrains.asState
import com.nikolam.kmm_weather.common.main.WeatherMainModel

val LocalTemUnit = compositionLocalOf<String> { error("No data found!") }

@Composable
fun WeatherMainContent(component: WeatherMainModel) {
    val model by component.models.asState()

    val (tempUnit, setTempUnit) = remember { mutableStateOf("C") } // F or C
    val checkedState = remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalTemUnit provides tempUnit) {
        Box(
            modifier = Modifier
                .width(800.dp)
                .fillMaxHeight()
                .background(
                    brush = Brush.linearGradient(
                        if (!isSystemInDarkTheme()) {
                            listOf(DarkPurple, MediumPurple, SkyBlue)
                        } else {
                            listOf(DarkDarkPurple, DarkMediumPurple, DarkSkyBlue)
                        }
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),

                ) {
                Row(Modifier.fillMaxWidth()) {
                    SearchBox(Modifier.weight(1f))
                    Text(
                        "C°",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Switch(
                        colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.secondary),
                        checked = checkedState.value, onCheckedChange = { fahrenheit ->
                            checkedState.value = fahrenheit
                            if (fahrenheit) {
                                setTempUnit("F")
                            } else {
                                setTempUnit("C")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 5.dp)
                            .weight(0.2f)
                    )
                    Text(
                        "F",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 5.dp),
                        color = MaterialTheme.colors.onPrimary
                    )
                }

                CurrentWeather(Modifier.weight(0.3f))
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.1f)
                )
                WindAndHumidityBox(
                    Modifier
                        .weight(0.3f)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.1f)
                )

                Text(
                    "Daily Forecast",
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(
                            Alignment.CenterHorizontally
                        )
                        .padding(bottom = 5.dp), textAlign = TextAlign.Center
                )

                Divider(
                    thickness = 1.dp, color = Color.White, modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .align(
                            Alignment.CenterHorizontally
                        )
                        .padding(bottom = 10.dp)
                )

                NextDaysForecast(
                    modifier = Modifier
                        .weight(0.2f)
                )
            }
        }
    }
}


@Composable()
fun NextDaysForecast(modifier: Modifier) {
    Row(modifier.fillMaxWidth()) {
        listOf("32", "28", "13", "17", "13", "18", "15").forEach {
            DayForecast(Modifier.weight(1f))
            if (it != "15") {
                Divider(
                    Modifier
                        .fillMaxHeight(0.5f)
                        .width(1.dp), color = Color.White,
                    thickness = 1.dp
                )
            }
        }
    }
}

@Composable()
fun DayForecast(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.align(Alignment.TopCenter)) {
            if (isSystemInDarkTheme()) {
                Image(
                    loadWeatherIcon(id = 123),
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    contentDescription = "current weather image displaying the current weather",
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                )
            } else {
                Image(
                    loadWeatherIcon(id = 123),
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    contentDescription = "current weather image displaying the current weather"
                )
            }
            Text(
                text = "27".toTempUnit(LocalTemUnit.current), fontSize = 18.sp, modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally), color = MaterialTheme.colors.onPrimary
            )
        }
    }
}


@Composable
fun WindAndHumidityBox(modifier: Modifier) {
    Surface(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .height(IntrinsicSize.Min)
            .fillMaxWidth(), shape = RoundedCornerShape(8.dp),
        color = Color.White.copy(alpha = 0.4f)
    ) {
        Row(
            Modifier
                .height(IntrinsicSize.Min)
                .padding(20.dp)
                .width(IntrinsicSize.Max),  //Padding inside the Row
            horizontalArrangement = Arrangement.Center,
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .height(IntrinsicSize.Min)
                    .weight(0.3f)
            ) {
                if (isSystemInDarkTheme()) {
                    Image(
                        loadWeatherIcon(id = 123),
                        contentDescription = "humidity",
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                    )
                } else {
                    Image(
                        loadWeatherIcon(id = 123),
                        contentDescription = "humidity"
                    )
                }
                Text(
                    text = "Precipitation \n 10%", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp, end = 10.dp),
                    color = MaterialTheme.colors.onSecondary
                )
            }

            Spacer(modifier = Modifier.weight(0.05f))
            Divider(
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .width(1.dp)
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colors.onPrimary,
                thickness = 1.dp
            )
            Spacer(modifier = Modifier.weight(0.05f))


            Row(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .height(IntrinsicSize.Min)
                    .weight(0.3f)
            ) {
                if (isSystemInDarkTheme()) {
                    Image(
                        loadWeatherIcon(id = 123),
                        contentDescription = "humidity",
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                    )
                } else {
                    Image(
                        loadWeatherIcon(id = 123),
                        contentDescription = "humidity"
                    )
                }
                Text(
                    text = "Precipitation \n 10%", fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp, end = 10.dp),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }

    }
}

@Composable
private fun CurrentWeather(modifier: Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        Column(Modifier.align(Alignment.Center)) {

            Column(modifier = Modifier.padding(bottom = 20.dp)) { // location and time/date
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Icon(
                        painter = loadWeatherIcon(id = 1234),
                        contentDescription = "location",
                        tint = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = "London",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = MaterialTheme.colors.onPrimary
                    )
                }

                Text(text = "Thu 4 December 8:41 am", color = MaterialTheme.colors.onPrimary)

            }


            Row(Modifier.align(Alignment.CenterHorizontally)) {

                if (isSystemInDarkTheme()) {
                    Image(
                        loadWeatherIcon(id = 123),
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        contentDescription = "current weather image displaying the current weather",
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                    )
                } else {
                    Image(
                        loadWeatherIcon(id = 123),
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        contentDescription = "current weather image displaying the current weather",
                    )
                }

                Text(
                    text = "27".toTempUnit(LocalTemUnit.current),
                    fontSize = 40.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.Top),
                    color = MaterialTheme.colors.onPrimary
                )
            }

            Text(
                text = "Sunny",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary,
                fontSize = 20.sp
            )
        }
    }
}

