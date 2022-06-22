package com.eventbrite.androidchallenge.ui.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eventbrite.androidchallenge.usecase.EventUseCase

class EventsViewModelFactory(private val eventUseCase: EventUseCase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventsViewModel::class.java)) {
            return EventsViewModel(eventUseCase) as T
        } else {
            throw IllegalArgumentException("ViewModel $modelClass not supported")
        }
    }
}