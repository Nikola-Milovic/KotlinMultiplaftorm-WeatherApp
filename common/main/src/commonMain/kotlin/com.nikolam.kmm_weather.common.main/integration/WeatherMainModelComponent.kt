package com.nikolam.kmm_weather.common.main.integration

import com.nikolam.kmm_weather.common.utils.asValue
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.badoo.reaktive.base.invoke
import com.nikolam.kmm_weather.common.main.store.WeatherMainStoreProvider
import com.nikolam.kmm_weather.common.utils.getStore
import com.nikolam.kmm_weather.common.main.WeatherMainModel

class WeatherMainModelComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    private val output: Consumer<WeatherMainModel.Output>
) : WeatherMainModel, ComponentContext by componentContext {

    private val store =
        instanceKeeper.getStore {
            WeatherMainStoreProvider(
                storeFactory = storeFactory,
                ///  database = TodoMainStoreDatabase(queries = database.todoDatabaseQueries)
            ).provide()
        }

    override val models: Value<WeatherMainModel.Model> = store.asValue().map(STATE_TO_MODEL)

    override fun onItemClicked(id: Long) {
        output(WeatherMainModel.Output.SelectedDay(id = id))
    }
}
