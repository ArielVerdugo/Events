package com.eventbrite.androidchallenge.usecase

import com.eventbrite.androidchallenge.data.EventsRepository
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class EventUseCase@Inject constructor(
    private val eventsRepository: EventsRepository) {

    suspend fun executeGetEvents():Response<EventsDto>  {
        lateinit var events: Response<EventsDto>
        withContext(Dispatchers.IO){
            events = eventsRepository.validarDatos()
        }
        return events
    }
}