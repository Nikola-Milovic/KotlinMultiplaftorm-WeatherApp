//
//  MainView.swift
//  kmm_weather
//
//  Created by Nikola Milovic on 19/06/2021.
//

import SwiftUI
import Weather


let DarkPurple = hexStringToColor(hex: "#5550F2")
let SkyBlue = hexStringToColor(hex: "#8CCEF4")
let MediumPurple = hexStringToColor(hex: "#6187F6")

let DarkDarkPurple = hexStringToColor(hex: "#00002c")
let DarkSkyBlue = hexStringToColor(hex: "#443381")
let DarkMediumPurple = hexStringToColor(hex: "#110c54")
let DarkTextColor = hexStringToColor(hex: "#87a1ff")

struct MainView: View {
    
    @State private var isFahrenheit = false
    
    @ObservedObject
    private var model : ObservableValue<WeatherMainModel>
    
    init (_ component : WeatherMainComponent) {
        self.model = ObservableValue(component.models)
    }

    var body: some View {
        
        ZStack () {
            LinearGradient(gradient: Gradient(colors: [DarkPurple, MediumPurple, SkyBlue]), startPoint: .topLeading, endPoint: .bottomTrailing).ignoresSafeArea(.all)
            
            
            if model.value.isError || model.value.isLoading{
                EmptyView()
            } else {


            VStack(alignment: .center) {
                HStack {
                    SearchBox(text: .constant("")).frame(width: 220)
                    Text("C").foregroundColor(.white)
                    Toggle("", isOn: $isFahrenheit).frame(width: 50).padding(4)
                    Text("F").foregroundColor(.white)
                }
                .padding(.horizontal)
                Group {
                Spacer().frame(height: 10.0)
                CurrentWeather(isFahrenheit: isFahrenheit, currentWeather : model.value.currentWeather!)
                    Text(model.value.currentWeather!.weatherDesc.capitalized).foregroundColor(.white).padding(.top)
                Spacer()
                HumidityAndWindBox(humidity: model.value.currentWeather!.humidity, wind : model.value.currentWeather!.wind)
                }
                Text("Daily Forecast").foregroundColor(.white)
                Divider().frame(width: 250).background(Color.white)
                Spacer(minLength: 5)
                DailyForecast(isFahrenheit: isFahrenheit, forecast : model.value.currentWeather!.daily)
                
                Spacer(minLength: 5)
                
            }.padding(15.0)
        }
        }

    }
}

struct DailyForecast: View {
    let fahr: Bool

    private let forecast : [DailyWeatherModel]
    init(isFahrenheit: Bool, forecast : [DailyWeatherModel]) {
        fahr = isFahrenheit
        self.forecast = forecast
    }

    var body: some View {
        HStack(spacing: 20) {
            ForEach(forecast, id: \.self) { day in
                DayView(isFahrenheit: fahr, day : day)
            }
        }
    }
}


struct DayView: View {

    let fahr: Bool
    
    private var day : DailyWeatherModel

    init(isFahrenheit: Bool, day : DailyWeatherModel) {
        fahr = isFahrenheit
        self.day = day
    }

    var body: some View {
        VStack(alignment: .center) {
            Image(getWeatherIconStringFromWeatherID(id: day.weatherID)).resizable().aspectRatio(contentMode: .fit).frame(width: 40, height: 40)
            Text(formatTempString(str: String(day.temp), fahr: fahr)).foregroundColor(.white)
        }
    }
}

struct HumidityAndWindBox: View {
    
    private var humidity : Int32
    private var wind : Int32
    
    init(humidity : Int32, wind : Int32){
        self.humidity = humidity
        self.wind = wind
    }
    var body: some View {
        ZStack (alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/) {
            Rectangle().frame(height: 180).padding().foregroundColor(Color.white.opacity(0.3))
            HStack {
                Image(systemName: "drop").resizable().aspectRatio(contentMode: .fit).frame(width: 40, height: 40).foregroundColor(.white)
                Text("Humidity \n \(humidity)%").foregroundColor(.white)
                Divider().background(Color.white).frame(height: 120)
                Image(systemName: "wind").resizable().aspectRatio(contentMode: .fit).frame(width: 40, height: 40).foregroundColor(.white)
                Text("Wind \n \(wind) m/s").foregroundColor(.white)
            }
        }
    }
}

struct CurrentWeather: View {

    let fahr: Bool
    private var currentWeather : CurrentWeatherModel

    init(isFahrenheit: Bool, currentWeather : CurrentWeatherModel) {
        fahr = isFahrenheit
        self.currentWeather = currentWeather
    }

    var body: some View {
        VStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/) {
            HStack {
                Image(systemName: "location").resizable().aspectRatio(contentMode: .fit).frame(width: 30, height:30).foregroundColor(.white)
                Text("London").font(.largeTitle).foregroundColor(.white)
            }

            Text(getCurrentDate()).foregroundColor(.white)

            HStack {
                Image(getWeatherIconStringFromWeatherID(id: currentWeather.weatherID)).resizable().aspectRatio(contentMode: .fit).frame(width: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/, height: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/, alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/)
                Text(formatTempString(str: String(currentWeather.temp), fahr: fahr)).font(.largeTitle).foregroundColor(.white)
            }
        }
    }
}
