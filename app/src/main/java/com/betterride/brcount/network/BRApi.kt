package com.betterride.brcount.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class BRApi {
    companion object {
        val baseUrl = "http://demo5617161.mockable.io/"
        val countingsessions = "$baseUrl/countingsessions"
        val everythingUrl = "$baseUrl/v2/everything"
        val sourcesUrl = "$baseUrl/v2/sources"

        fun requestHeadlines(key: String,
                             responseHandler: (SessionsResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit) {
            AndroidNetworking.get(BRApi.countingsessions)
                    .setPriority(Priority.LOW)
                    .setTag("BRCount")
                    .build()
                    .getAsObject(SessionsResponse::class.java, object : ParsedRequestListener<SessionsResponse> {
                        override fun onResponse(response: SessionsResponse?) {
                            responseHandler(response)
                        }
                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })
        }
    }
}