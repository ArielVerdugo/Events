package com.eventbrite.androidchallenge.data

import com.eventbrite.androidchallenge.data.events.client.ApiClient
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import retrofit2.Response
import javax.inject.Inject

class EventsRepository@Inject constructor(private val apiClient: ApiClient) {

    suspend fun validarDatos(): Response<EventsDto> {
        return apiClient.getEvents()
    }
}