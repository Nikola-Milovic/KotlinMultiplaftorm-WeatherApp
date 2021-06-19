//
//  Utils.swift
//  kmm_weather
//
//  Created by Nikola Milovic on 19/06/2021.
//

import SwiftUI

func hexStringToColor (hex: String) -> Color {
    var cString: String = hex.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()

    if (cString.hasPrefix("#")) {
        cString.remove(at: cString.startIndex)
    }

    if ((cString.count) != 6) {
        return Color.gray
    }

    var rgbValue: UInt64 = 0
    Scanner(string: cString).scanHexInt64(&rgbValue)

    return Color(
        red: Double(CGFloat((rgbValue & 0xFF0000) >> 16)) / 255.0,
        green: Double(CGFloat((rgbValue & 0x00FF00) >> 8)) / 255.0,
        blue: Double(CGFloat(rgbValue & 0x0000FF) / 255.0)
    )
}


func getCurrentDate() -> String {
    let currentDateTime = Date()
    // initialize the date formatter and set the style
    let formatter = DateFormatter()
    formatter.timeStyle = .short
    formatter.dateStyle = .medium

    return formatter.string(from: currentDateTime)
}

func formatTempString(str: String, fahr: Bool) -> String {
    if !fahr {
        var appendString = str + "C"
        return appendString
    } else {
        return String(Int(((Double(str) ?? 0 * 1.8) + 32))) + "F"
    }
}

func getWeatherIconStringFromWeatherID(id : Int32) -> String {
    switch id {
    case 200..<233:
       return "thunder"
    case 300..<322:
        return "day_rain"
    case 500..<532:
        return "rain"
    case 600..<623:
        return "snow"
    case 800:
        return "day_clear"
    case 801..<805:
        return "cloudy"
    default:
        return "day_clear"
    }
}
