package com.betterride.bradmin.network

import com.betterride.bradmin.models.Project

class ProjectsResponse {
    var status: String = ""
    var code: String? = null
    var message: String? = null
    var projects: ArrayList<Project>? = null
}