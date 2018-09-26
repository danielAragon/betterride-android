package com.betterride.brcount.network

import com.betterride.brcount.models.Session


class SessionsResponse {
    var status: String = ""
    var code: String? = null
    var message: String? = null
    var sessions: ArrayList<Session>? = null
}
