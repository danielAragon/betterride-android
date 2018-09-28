package com.betterride.brcount.viewcontrollers.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.betterride.brcount.R
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageLogo.setImageUrl("https://raphaelbravo190813.github.io/LandingPage/img/LogoBetter.png")
        startButton.setOnClickListener { view ->
            val intent: Intent
            intent = Intent(this, CountingSessionsActivity::class.java)
            startActivity(intent)
        }
    }
}
