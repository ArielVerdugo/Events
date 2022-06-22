package com.eventbrite.androidchallenge.usecase

import com.eventbrite.androidchallenge.data.EventsRepository
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventUseCase@Inject constructor(
    private val eventsRepository: EventsRepository) {

    suspend fun executeGetEvents():EventsDto  {
        lateinit var events: EventsDto
        withContext(Dispatchers.IO){
            events = eventsRepository.validarDatos()
        }
        return events
    }
}