package com.betterride.brcount.viewcontrollers.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent: Intent
        intent = Intent(this, CountingSessionsActivity::class.java)
        startActivity(intent)
    }
}
