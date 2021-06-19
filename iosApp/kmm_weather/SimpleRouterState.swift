//
//  SimpleRouterState.swift
//  kmm_weather
//
//  Created by Nikola Milovic on 19/06/2021.
//

import Weather

func simpleRouterState<T : AnyObject>(_ child: T) -> Value<RouterState<AnyObject, T>> {
    return valueOf(
        RouterState(
            activeChild: ChildCreated(
                configuration: "config" as AnyObject,
                instance: child
            ),
            backStack: []
        )
    )
}
