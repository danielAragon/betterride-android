package com.betterride.bradmin

import android.app.Application
import com.androidnetworking.AndroidNetworking


class BRAdminApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}