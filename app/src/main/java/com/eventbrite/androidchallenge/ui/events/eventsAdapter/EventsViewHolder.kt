package com.eventbrite.androidchallenge.ui.events.eventsAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eventbrite.androidchallenge.data.events.model.EventDto
import com.eventbrite.androidchallenge.databinding.EventCardBinding

class EventsViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val binding = EventCardBinding.bind(view)

    fun render(event: EventDto?){
        binding.eventName.text = event?.name
        binding.eventStart.text = event?.startDate.toString()
        Glide.with(binding.eventName.context)
            .load(event?.image?.url.toString())
            .override(100, 100)
            .into(binding.eventImage)
    }
}