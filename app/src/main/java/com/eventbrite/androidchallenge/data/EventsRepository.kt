package com.eventbrite.androidchallenge.data

import com.eventbrite.androidchallenge.data.events.client.ApiClient
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import javax.inject.Inject

class EventsRepository@Inject constructor(private val apiClient: ApiClient) {

    suspend fun validarDatos(): EventsDto {
        return apiClient.getEvents()
    }
}