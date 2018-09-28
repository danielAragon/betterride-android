package com.betterride.brcount.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.betterride.brcount.viewcontrollers.adapters.CountingStatus

class BRApi {
    companion object {
        val baseUrl = "http://demo5617161.mockable.io"
        val pendingsessions = "$baseUrl/pendingsessions"
        val donesessions = "$baseUrl/donesessions"

        fun requestHeadlines(status: CountingStatus,
                             responseHandler: (SessionsResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit) {
            var url = if (status == CountingStatus.PENDING) {
                BRApi.pendingsessions
            } else {
                BRApi.donesessions
            }
            AndroidNetworking.get(url)
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