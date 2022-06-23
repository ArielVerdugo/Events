package com.eventbrite.androidchallenge.data.events.client

import com.eventbrite.androidchallenge.data.events.model.EventsDto
import com.eventbrite.androidchallenge.data.events.model.ServiceResponse
import retrofit2.Response

interface ApiClient {

    suspend fun getEvents(): ServiceResponse<EventsDto>
}