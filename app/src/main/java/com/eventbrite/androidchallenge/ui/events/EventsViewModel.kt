package com.eventbrite.androidchallenge.ui.events

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import com.eventbrite.androidchallenge.data.events.model.ServiceResponse
import com.eventbrite.androidchallenge.usecase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
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
            val result = eventUseCase.executeGetEvents()
            manageResponse(result)
        }
    }

    private fun showProgress() {
        _showProgress.value = true
    }

    private fun hideProgress() {
        _showProgress.value = false
    }

    private fun manageResponse(response:ServiceResponse<EventsDto>){
        if (response.successful){
            _events.postValue(response.body)
            hideProgress()
        }else{
            //Todo algo que falle
            Log.d("aaa","falloooo")
            hideProgress()
        }


    }


}