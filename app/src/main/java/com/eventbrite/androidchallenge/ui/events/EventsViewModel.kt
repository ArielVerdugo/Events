package com.eventbrite.androidchallenge.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import com.eventbrite.androidchallenge.usecase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class EventsViewModel@Inject constructor(private val eventUseCase: EventUseCase) : ViewModel(){

    private val _events = MutableLiveData<EventsDto>()
    val events: LiveData<EventsDto> get() = _events

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgressIndicator: LiveData<Boolean> get() = _showProgress

    fun getEvents(){
        showProgress()
        viewModelScope.launch {
            //val result = eventUseCase.executeGetEvents()
            //_events.postValue(result)
            //hideProgress()

            val result = eventUseCase.executeGetEvents()

            if (result.isSuccessful){
                val code = result.code()
            }else{
                val code = result.code()
            }
        }
    }

    private fun showProgress() {
        _showProgress.value = true
    }

    private fun hideProgress() {
        _showProgress.value = false
    }

}