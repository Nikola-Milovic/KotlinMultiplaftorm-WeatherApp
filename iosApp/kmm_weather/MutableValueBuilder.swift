//
//  MutableValueBuilder.swift
//  kmm_weather
//
//  Created by Nikola Milovic on 19/06/2021.
//

import Foundation
import Weather

func valueOf<T: AnyObject>(_ value: T) -> Value<T> {
    return MutableValueBuilderKt.MutableValue(initialValue: value) as! MutableValue<T>
}
