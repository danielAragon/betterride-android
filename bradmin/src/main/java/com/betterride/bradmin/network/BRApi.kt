package com.betterride.bradmin.network

import android.renderscript.RenderScript
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class BRApi {
    companion object {
        val baseUrl = "http://demo5617161.mockable.io/"
        val projects = "$baseUrl/projects"
        val operators = "$baseUrl/operators"


        fun requestGetProjects(responseHandler: (ProjectsResponse?) -> Unit,
                               errorHandler: (ANError?) -> Unit) {
            AndroidNetworking.get(BRApi.projects)
                    .setPriority(Priority.LOW)
                    .setTag("BradminApp")
                    .build()
                    .getAsObject(ProjectsResponse::class.java,
                            object : ParsedRequestListener<ProjectsResponse> {

                                override fun onResponse(response: ProjectsResponse?) {
                                    responseHandler(response)
                                }
                                override fun onError(anError: ANError?) {
                                    errorHandler(anError)
                                }
                            })
        }

        fun requestOperators(responseHandler: (OperatorsResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit) {
            AndroidNetworking.get(BRApi.operators)
                    .setPriority(Priority.LOW)
                    .setTag("BradminApp")
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