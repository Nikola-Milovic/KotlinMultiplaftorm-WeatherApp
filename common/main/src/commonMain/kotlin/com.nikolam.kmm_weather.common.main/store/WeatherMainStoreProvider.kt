package com.nikolam.kmm_weather.common.main.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.reaktive.ReaktiveExecutor
import com.nikolam.kmm_weather.common.main.WeatherItem
import com.nikolam.kmm_weather.common.main.store.WeatherMainStore.State

internal class WeatherMainStoreProvider(
    private val storeFactory: StoreFactory
) {

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
        data class ItemsLoaded(val items: List<WeatherItem>) : Result()
        data class ItemsLoadFailed(val err: Int) : Result()
    }

    private inner class ExecutorImpl :
        ReaktiveExecutor<WeatherMainStore.Intent, Unit, State, Result, Nothing>() {
        override fun executeAction(action: Unit, getState: () -> State) {
            dispatch(
                Result.ItemsLoaded(
                    listOf(
                        WeatherItem("1"),
                        WeatherItem("2"),
                        WeatherItem("3")
                    )
                )
            )
//            database
//                .updates
//                .observeOn(mainScheduler)
//                .map(Result::ItemsLoaded)
//                .subscribeScoped(onNext = ::dispatch)
        }
    }

    private object ReducerImpl : Reducer<State, Result> {
        override fun State.reduce(result: Result): State =
            when (result) {
                is Result.ItemsLoaded -> copy(items = result.items)
                is Result.ItemsLoadFailed -> copy()
            }
    }
}