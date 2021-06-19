//
//  ContentView.swift
//  kmm_weather
//
//  Created by Nikola Milovic on 12/06/2021.
//

import SwiftUI
import Weather

struct ContentView: View {
    @State
    private var componentHolder = ComponentHolder{ WeatherRootComponent(componentContext: $0, storeFactory: DefaultStoreFactory())}
    
    var body: some View {
        RootView(componentHolder.component)
            .onAppear { LifecycleRegistryExtKt.resume(self.componentHolder.lifecycle) }
            .onDisappear { LifecycleRegistryExtKt.stop(self.componentHolder.lifecycle) }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
