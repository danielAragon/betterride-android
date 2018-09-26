package com.betterride.brcount.viewcontrollers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.betterride.brcount.R
import com.betterride.brcount.models.Session
import kotlinx.android.synthetic.main.item_session.view.*

class CountingSessionsAdapter(var sessions: ArrayList<Session>,
                              val context: Context) :
        RecyclerView.Adapter<CountingSessionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.item_session, parent, false))
    }

    override fun getItemCount(): Int {
        return sessions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val session = sessions.get(position)
        holder.updateFrom(session)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val dayTextView = view.dayTextView
        val monthTextView = view.monthTextView
        val scheduleTextView = view.scheduleTextView
        val junctionTextView = view.junctionTextView
        val laneTextView = view.laneTextView
        val sessionCardView = view.cardView

        fun updateFrom(session: Session) {
            dayTextView.text = session.day
            monthTextView.text = session.month
            scheduleTextView.text = session.schedule
            junctionTextView.text = session.junction
            laneTextView.text = session.lane
            sessionCardView.setOnClickListener { view ->
                val context = view.context
//                context.startActivity(
//                        Intent(context, ArticleActivity::class.java)
//                                .putExtras(session.toBundle()))

            }
        }
    }
}