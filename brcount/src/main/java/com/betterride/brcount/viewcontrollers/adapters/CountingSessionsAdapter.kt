package com.betterride.brcount.viewcontrollers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.betterride.brcount.R
import com.betterride.brcount.models.Session
import com.betterride.brcount.viewcontrollers.activities.CountingActivity
import com.betterride.brcount.viewcontrollers.activities.ReportingActivity
import kotlinx.android.synthetic.main.item_session.view.*
enum class CountingStatus{
    PENDING, DONE
}
class CountingSessionsAdapter(var sessions: ArrayList<Session>,
                              val context: Context,
                              val status: CountingStatus) :
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
        holder.updateFrom(session, status)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val dayTextView = view.dayTextView
        val monthTextView = view.monthTextView
        val scheduleTextView = view.scheduleTextView
        val junctionTextView = view.junctionTextView
        val laneTextView = view.laneTextView
        val sessionCardView = view.cardView

        fun updateFrom(session: Session, status: CountingStatus) {
            dayTextView.text = session.day
            monthTextView.text = session.month
            scheduleTextView.text = session.schedule
            junctionTextView.text = session.junction
            laneTextView.text = session.lane
            sessionCardView.setOnClickListener { view ->
                val context = view.context
                if (status == CountingStatus.PENDING) {
                    context.startActivity(
                            Intent(context, CountingActivity::class.java)
                                    .putExtras(session.toBundle()))
                }else{
                    context.startActivity(
                            Intent(context, ReportingActivity::class.java)
                                    .putExtras(session.toBundle()))
                }
            }
        }
    }
}