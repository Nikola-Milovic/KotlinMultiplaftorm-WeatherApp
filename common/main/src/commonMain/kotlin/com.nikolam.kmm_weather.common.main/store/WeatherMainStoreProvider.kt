package com.nikolam.kmm_weather.common.main.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import com.nikolam.kmm_weather.common.main.data.model.CurrentWeatherModel
import com.nikolam.kmm_weather.common.main.data.network.WeatherAPI
import com.nikolam.kmm_weather.common.main.store.WeatherMainStore.State
import com.nikolam.kmm_weather.common.utils.PlatformServiceLocator
import io.github.aakira.napier.Napier

internal class WeatherMainStoreProvider(
    private val storeFactory: StoreFactory,
) {

    private val weatherAPI by lazy { WeatherAPI(PlatformServiceLocator.httpClientEngine) }

    fun provide(): WeatherMainStore =
        object : WeatherMainStore,
            Store<WeatherMainStore.Intent, State, Nothing> by storeFactory.create(
                name = "TodoListStore",
                initialState = State(),
                bootstrapper = SimpleBootstrapper(Unit),
                executorFactory = ::ExecutorImpl,
                reducer = ReducerImpl
            ) {}


    private sealed class Result {
        data class WeatherLoaded(
            val currentWeather: CurrentWeatherModel
        ) : Result()

        data class ItemsLoadFailed(val err: Int) : Result()
    }

    private inner class ExecutorImpl :
        SuspendExecutor<WeatherMainStore.Intent, Unit, State, Result, Nothing>() {
        override suspend fun executeAction(action: Unit, getState: () -> State) {
            try {
                val m = weatherAPI.getWeather()
                Napier.d("Sucess $m\n", tag = "my_tag")
                dispatch(Result.WeatherLoaded(m))
            } catch (e: Exception) {
                Napier.e(e.toString(), e, tag = "my_tag")
                dispatch(Result.ItemsLoadFailed(-1))
            }
        }
    }

    private object ReducerImpl : Reducer<State, Result> {
        override fun State.reduce(result: Result): State =
            when (result) {
                is Result.WeatherLoaded -> copy(
                    currentWeather = result.currentWeather,
                    isLoading = false,
                    isError = false
                )
                is Result.ItemsLoadFailed -> copy(isLoading = false, isError = true)
            }
    }
}