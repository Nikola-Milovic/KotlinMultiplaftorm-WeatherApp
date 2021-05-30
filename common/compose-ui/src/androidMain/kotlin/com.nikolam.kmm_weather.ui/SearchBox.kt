package com.nikolam.kmm_weather.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
actual fun SearchBox(modifier: Modifier) {
    Box(modifier) {
        var textValue by remember { mutableStateOf("") }

        val context = LocalContext.current

        OutlinedTextField(value = textValue,
            leadingIcon = {
                Icon(
                    loadWeatherIcon(id = 12345),
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
                    hideKeyboard(context = context)
                }),
            onValueChange = { text ->
                textValue = text
            }
        )
    }
}