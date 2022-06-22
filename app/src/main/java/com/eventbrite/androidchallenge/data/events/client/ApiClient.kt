package com.eventbrite.androidchallenge.data.events.client

import com.eventbrite.androidchallenge.data.events.model.EventsDto

interface ApiClient {

    suspend fun getEvents():EventsDto
}