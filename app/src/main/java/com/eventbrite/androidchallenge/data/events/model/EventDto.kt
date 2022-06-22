package com.eventbrite.androidchallenge.data.events.model

import com.google.gson.annotations.SerializedName
import java.net.URL
import java.util.*

data class EventDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("start_date")
    val startDate: Date,
    @SerializedName("image")
    val image: ImageDto? = null
)

data class EventsDto(
    @SerializedName("events")
    val events: List<EventDto>? = null
)

data class ImageDto(
    @SerializedName("url")
    val url: URL
)