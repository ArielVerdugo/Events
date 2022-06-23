package com.eventbrite.androidchallenge.data.events.client

import com.eventbrite.androidchallenge.data.events.EventsService
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ApiClientImpl @Inject constructor(private val apiClient: EventsService): ApiClient{
    override suspend fun getEvents(): Response<EventsDto> {
        return withContext(Dispatchers.IO){
            val response = apiClient.listOrganizerEvents()
            response
        }
    }
}