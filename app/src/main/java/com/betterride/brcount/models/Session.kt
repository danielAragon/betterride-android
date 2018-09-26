package com.betterride.brcount.models

import android.os.Bundle

data class Session(val day: String,
                   val month: String,
                   val schedule: String,
                   val junction: String,
                   val lane: String)
{
    companion object {
        fun from(bundle: Bundle): Session {
            return Session(
                    bundle.getString("day")!!,
                    bundle.getString("month")!!,
                    bundle.getString("schedule")!!,
                    bundle.getString("junction")!!,
                    bundle.getString("lane")!!
            )
        }
    }

    fun toBundle() : Bundle {
        val bundle = Bundle()
        bundle.putString("day", day)
        bundle.putString("month", month)
        bundle.putString("schedule", schedule)
        bundle.putString("junction", junction)
        bundle.putString("lane", lane)
        return bundle
    }
}