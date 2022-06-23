package com.eventbrite.androidchallenge.usecase

import com.eventbrite.androidchallenge.data.EventsRepository
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import com.eventbrite.androidchallenge.data.events.model.ServiceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class EventUseCase@Inject constructor(
    private val eventsRepository: EventsRepository) {

    suspend fun executeGetEvents(): ServiceResponse<EventsDto> {
        lateinit var events: ServiceResponse<EventsDto>
        withContext(Dispatchers.IO){

            events = eventsRepository.getEvents()
        }
        return events
    }
}