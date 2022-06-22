package com.eventbrite.androidchallenge.ui.events.eventsAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eventbrite.androidchallenge.R
import com.eventbrite.androidchallenge.data.events.model.EventsDto

class EventsAdapter(private val eventsList:EventsDto): RecyclerView.Adapter<EventsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EventsViewHolder(layoutInflater.inflate(R.layout.event_card,parent,false))
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val eventItem = eventsList.events?.get(position)
        holder.render(eventItem)
    }

    override fun getItemCount(): Int = eventsList.events.let { eventsList.events!!.size }

}