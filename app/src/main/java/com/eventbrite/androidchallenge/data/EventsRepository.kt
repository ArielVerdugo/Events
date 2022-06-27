package com.eventbrite.androidchallenge.data

import com.eventbrite.androidchallenge.data.events.client.ApiClient
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import com.eventbrite.androidchallenge.data.events.model.ServiceResponse
import javax.inject.Inject

class EventsRepository@Inject constructor(private val apiClient: ApiClient) {

    suspend fun getEvents(): ServiceResponse<EventsDto> {
        return apiClient.getEvents()
    }
}