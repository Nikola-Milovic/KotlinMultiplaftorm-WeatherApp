package com.nikolam.kmm_weather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.arkivanov.decompose.extensions.compose.jetbrains.asState
import com.nikolam.kmm_weather.common.main.WeatherMainModel
import com.nikolam.kmm_weather.common.main.data.model.DailyWeatherModel
import io.github.aakira.napier.*

//import androidx.compose.material.icons.outlined

val LocalTemUnit = compositionLocalOf<String> { error("No data found!") }

@Composable
fun WeatherMainContent(component: WeatherMainModel) {
    val model by component.models.asState()

    val (tempUnit, setTempUnit) = remember { mutableStateOf("C") } // F or C
    val checkedState = remember { mutableStateOf(false) }

    Napier.d("Weather is $model", tag = "my_tag")

    if (model.isError || model.currentWeather == null) {
        Napier.d("Weather is " + model.currentWeather.toString())
        return
    }

    CompositionLocalProvider(LocalTemUnit provides tempUnit) {
        Box(
            modifier = Modifier
                .width(800.dp)
                .fillMaxHeight()
                .background(
                    brush = Brush.linearGradient(
                        if (!isDarkMode()) {
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

                CurrentWeather(
                    Modifier.weight(0.3f),
                    model.currentWeather!!.weatherID,
                    model.currentWeather!!.temp,
                    model.currentWeather!!.weatherDesc
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.1f)
                )
                WindAndHumidityBox(
                    Modifier
                        .weight(0.3f),
                    model.currentWeather!!.humidity,
                    model.currentWeather!!.wind
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
                        .weight(0.2f),
                    model.currentWeather!!.daily
                )
            }
        }
    }
}


@Composable()
fun NextDaysForecast(modifier: Modifier, forecast: List<DailyWeatherModel>) {
    Row(modifier.fillMaxWidth()) {
        for (i in forecast.indices) {
            if (i > 6) {
                break
            }
            DayForecast(Modifier.weight(1f), forecast = forecast[i])
            if (i != 6) {
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
fun DayForecast(modifier: Modifier, forecast: DailyWeatherModel) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.align(Alignment.TopCenter)) {

            KMPImage(
                id = forecast.weatherID,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                contentDescription = "current weather image displaying the current weather",
                colorFilter = if (isDarkMode()) ColorFilter.tint(MaterialTheme.colors.onPrimary) else null
            )


            Text(
                text = forecast.temp.toString().toTempUnit(LocalTemUnit.current),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}


@Composable
fun WindAndHumidityBox(modifier: Modifier, humidity: Int, wind: Int) {
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


                KMPImage(
                    id = 1,
                    modifier = Modifier.scale(1.2f).align(Alignment.CenterVertically),
                    contentDescription = "humidity",
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary)
                )

                Text(
                    text = "Humidity \n $humidity%",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
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

                KMPImage(
                    id = 2,
                    modifier = Modifier.scale(1.2f).align(Alignment.CenterVertically),
                    contentDescription = "wind",
                    colorFilter =  ColorFilter.tint(MaterialTheme.colors.onPrimary)
                )

                Text(
                    text = "Wind \n $wind m/s", fontWeight = FontWeight.Bold, fontSize = 16.sp,
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
private fun CurrentWeather(modifier: Modifier, weatherID: Int, temp: Int, weatherDesc: String) {
    Box(modifier = modifier.fillMaxWidth()) {
        Column(Modifier.align(Alignment.Center)) {

            Column(modifier = Modifier.padding(bottom = 20.dp)) { // location and time/date
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Icon(
                        Icons.Filled.LocationOn,
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

                KMPImage(
                    id = weatherID,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    contentDescription = "current weather image displaying the current weather",
                    colorFilter = if (isDarkMode()) ColorFilter.tint(MaterialTheme.colors.onPrimary) else null
                )


                Text(
                    text = temp.toString().toTempUnit(LocalTemUnit.current),
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterVertically),
                    color = MaterialTheme.colors.onPrimary
                )
            }

            Text(
                text = weatherDesc.capitalize(),
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

@Composable
fun SearchBox(modifier: Modifier) {
    Box(modifier) {
        var textValue by remember { mutableStateOf("") }

        OutlinedTextField(value = textValue,
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    "search",
                    tint = MaterialTheme.colors.onPrimary
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.onPrimary,
                unfocusedBorderColor = MaterialTheme.colors.onPrimary
            ),
            label = { Text("Search For A City", color = MaterialTheme.colors.onPrimary) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    //  hideKeyboard(context = context)
                }),
            onValueChange = { text ->
                textValue = text
            }
        )
    }
}
