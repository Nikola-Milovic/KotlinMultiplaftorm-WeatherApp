package com.nikolam.kmm_weather.androidApp

import android.app.Application
import com.arkivanov.mvikotlin.timetravel.server.TimeTravelServer

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        TimeTravelServer().start()
    }
}
