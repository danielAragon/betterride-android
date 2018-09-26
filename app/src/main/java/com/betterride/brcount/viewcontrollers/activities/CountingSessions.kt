package com.betterride.brcount.viewcontrollers.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.betterride.brcount.R
import com.betterride.brcount.viewcontrollers.fragments.DoneSessionsFragment
import com.betterride.brcount.viewcontrollers.fragments.PendingSessionsFragment
import kotlinx.android.synthetic.main.activity_counting_sessions.*

class CountingSessions : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counting_sessions)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        navigation.selectedItemId = R.id.navigation_pending_sessions
    }

    private fun fragmentFor(item: MenuItem): Fragment {
        when(item.itemId) {
            R.id.navigation_pending_sessions -> {
                return PendingSessionsFragment()
            }
            R.id.navigation_done_sessions -> {
                return DoneSessionsFragment()
            }
        }
        return PendingSessionsFragment()
    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragmentFor(item))
                .commit() > 0
    }
}
