package com.example.travelmark

import android.app.Application
import com.example.travelmark.core.Constants
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(Constants.mapKitKey)
    }
}