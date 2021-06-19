//
//  RootView.swift
//  kmm_weather
//
//  Created by Nikola Milovic on 19/06/2021.
//

import SwiftUI
import Weather

struct RootView: View {
    @ObservedObject
    private var component: ObservableValue<WeatherRoot>

    init(_ component: WeatherRoot) {
        self.component = ObservableValue(valueOf(component))
    }

    var body: some View {
        let weatherMain = component.value.routerState.value.activeChild.instance as! WeatherRootChild.Main
        MainView(weatherMain.component as! WeatherMainComponent)
    }
}

struct RootView_Previews: PreviewProvider {
    static var previews: some View {
        RootView(StubWeatherRoot())
            .previewDevice("iPhone 8")
    }

    class StubWeatherRoot: WeatherRoot {
        var routerState: Value<RouterState<AnyObject, WeatherRootChild>> = simpleRouterState(WeatherRootChild.Main(component:StubWeatherMain()))
    }
    
    class StubWeatherMain : WeatherMain {
        func onItemClicked(id: Int64) {}
        
        var models: Value<WeatherMainModel> = valueOf(WeatherMainModel(currentWeather: CurrentWeatherModel(weatherID: 400, daily: [DailyWeatherModel(weatherID: 500, index:1, temp: 28)], temp: 32, wind: 15, humidity: 15, weatherDesc: "Cloudy"), isLoading: false, isError: false))
    }
}
