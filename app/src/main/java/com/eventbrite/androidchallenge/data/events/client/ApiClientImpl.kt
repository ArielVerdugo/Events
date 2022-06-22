package com.eventbrite.androidchallenge.data.events.client

import com.eventbrite.androidchallenge.data.events.EventsService
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiClientImpl @Inject constructor(private val apiClient: EventsService): ApiClient{
    override suspend fun getEvents(): EventsDto {
        return withContext(Dispatchers.IO){
            val response = apiClient.listOrganizerEvents()
            val response2 = response
            response
        }
    }
}