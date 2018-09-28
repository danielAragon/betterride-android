package com.betterride.bradmin.network

import android.renderscript.RenderScript
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class BRADApi {
    companion object {
        val baseUrl = "http://demo5617161.mockable.io/"
        val countingsessions = "$baseUrl/countingsessions"
        val operators = "$baseUrl/operators"


    fun requestOperators(key: String,
                         responseHandler: (OperatorsResponse?) -> Unit,
                         errorHandler: (ANError?) -> Unit) {
        AndroidNetworking.get(BRADApi.countingsessions)
                .setPriority(Priority.LOW)
                .setTag("BRAdmin")
                .build()
                .getAsObject(OperatorsResponse::class.java, object : ParsedRequestListener<OperatorsResponse> {
                    override fun onResponse(response: OperatorsResponse?) {
                        responseHandler(response)
                    }

                    override fun onError(anError: ANError?) {
                        errorHandler(anError)
                    }
                })
    }
}
}