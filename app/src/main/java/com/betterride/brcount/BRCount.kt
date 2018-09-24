package com.betterride.brcount;

import android.app.Application
import com.androidnetworking.AndroidNetworking


class BRCount : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}
