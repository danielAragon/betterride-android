package com.betterride.brcount.viewcontrollers.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError

import com.betterride.brcount.R
import com.betterride.brcount.models.Session
import com.betterride.brcount.network.BRApi
import com.betterride.brcount.network.SessionsResponse
import com.betterride.brcount.viewcontrollers.adapters.CountingSessionsAdapter
import com.betterride.brcount.viewcontrollers.adapters.CountingStatus
import kotlinx.android.synthetic.main.fragment_done_sessions.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DoneSessionsFragment : Fragment() {

    var sessions = ArrayList<Session>()
    lateinit var sessionsRecyclerView: RecyclerView
    lateinit var sessionsAdapter: CountingSessionsAdapter
    lateinit var sessionsLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_done_sessions, container, false)

        sessionsRecyclerView = view.sessionsRecyclerView
        sessionsAdapter = CountingSessionsAdapter(sessions, view.context, CountingStatus.DONE)
        sessionsLayoutManager = GridLayoutManager(view.context, 1)
        sessionsRecyclerView.adapter = sessionsAdapter
        sessionsRecyclerView.layoutManager = sessionsLayoutManager

        BRApi.requestHeadlines(CountingStatus.DONE,
                { response -> handleResponse(response)},
                { error -> handleError(error)})

        return view
    }

    private fun handleResponse(response: SessionsResponse?) {
        val status = response!!.status
        if (status.equals("error", true)) {
            Log.d("BRCount", response.message)
            return
        }

        sessions = response.sessions!!
        sessionsAdapter.sessions = sessions
        sessionsAdapter.notifyDataSetChanged()
    }

    private fun handleError(anError: ANError?) {
        Log.d("BRCount", anError!!.message)
    }
}
