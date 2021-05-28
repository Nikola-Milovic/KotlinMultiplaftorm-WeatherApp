package com.nikolam.kmm_weather.common.root.integration

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.RouterState
import com.arkivanov.decompose.router
import com.arkivanov.decompose.statekeeper.Parcelable
import com.arkivanov.decompose.statekeeper.Parcelize
import com.arkivanov.decompose.value.Value
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.badoo.reaktive.base.Consumer
import com.nikolam.kmm_weather.common.root.WeatherRoot
import com.nikolam.kmm_weather.common.main.WeatherMainModel
import com.nikolam.kmm_weather.common.main.integration.WeatherMainModelComponent
import com.nikolam.kmm_weather.common.root.WeatherRoot.*
import com.nikolam.kmm_weather.common.utils.Consumer

class WeatherRootComponent internal constructor(
    componentContext: ComponentContext,
    private val weatherMainModel : (ComponentContext, Consumer<WeatherMainModel.Output>) -> WeatherMainModel
) : WeatherRoot, ComponentContext by componentContext{

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory
    ) : this(
    componentContext = componentContext,
    weatherMainModel = { childContext, output ->
        WeatherMainModelComponent(
            componentContext = childContext,
            storeFactory = storeFactory,
            output = output
        )
    }
    )

    private val router =
        router<Configuration, Child>(
            initialConfiguration = Configuration.Main,
            handleBackButton = true,
            childFactory = ::createChild
        )

    override val routerState: Value<RouterState<*, Child>> = router.state

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Child =
        when (configuration) {
            is Configuration.Main -> Child.Main(weatherMainModel(componentContext, Consumer(::onMainOutput)))
        }

    private fun onMainOutput(output: WeatherMainModel.Output): Unit =
        when (output) {
            is WeatherMainModel.Output.SelectedDay -> {}// router.push(Configuration.Edit(itemId = output.id))
        }


    private sealed class Configuration : Parcelable {
        @Parcelize
        object Main : Configuration()
    }

}