package com.eventbrite.androidchallenge.data.events.client

import com.eventbrite.androidchallenge.data.events.model.EventsDto
import retrofit2.Response

interface ApiClient {

    suspend fun getEvents(): Response<EventsDto>
}