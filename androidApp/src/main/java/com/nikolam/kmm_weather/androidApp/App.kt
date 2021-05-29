package com.nikolam.kmm_weather.androidApp

import android.app.Application
import com.arkivanov.mvikotlin.timetravel.server.TimeTravelServer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        TimeTravelServer().start()
    }
}
