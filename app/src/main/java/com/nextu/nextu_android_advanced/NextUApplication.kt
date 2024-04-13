package com.nextu.nextu_android_advanced

import android.app.Application
import com.nextu.nextu_android_advanced.data.AppContainer
import com.nextu.nextu_android_advanced.data.DefaultAppContainer

class NextUApplication : Application() {

    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}