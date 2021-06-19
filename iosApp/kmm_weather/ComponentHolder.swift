//
//  ComponentHolder.swift
//  kmm_weather
//
//  Created by Nikola Milovic on 19/06/2021.
//

import Weather

class ComponentHolder<T> {
    let lifecycle: LifecycleRegistry
    let component: T
    
    init(factory: (ComponentContext) -> T) {
        let lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        let component = factory(DefaultComponentContext(lifecycle: lifecycle))
        self.lifecycle = lifecycle
        self.component = component

        lifecycle.onCreate()
    }
    
    deinit {
        lifecycle.onDestroy()
    }
}
