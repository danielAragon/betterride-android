package com.betterride.brcount.viewcontrollers.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.betterride.brcount.R

import kotlinx.android.synthetic.main.activity_counting.*
import kotlinx.android.synthetic.main.content_counting.*
import kotlinx.android.synthetic.main.content_main.*

class CountingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counting)
        setSupportActionBar(toolbar)
        endtButton.setOnClickListener { view ->
            finish() }
    }
}
