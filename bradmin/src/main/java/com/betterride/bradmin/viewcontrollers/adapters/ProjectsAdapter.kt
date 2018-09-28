package com.betterride.bradmin.viewcontrollers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.betterride.bradmin.R
import com.betterride.bradmin.models.Project

class ProjectsAdapter( var projects: ArrayList<Project>,
                       val context: Context): RecyclerView.Adapter<ProjectsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ProjectsAdapter.ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.item_project,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects.get(position)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}