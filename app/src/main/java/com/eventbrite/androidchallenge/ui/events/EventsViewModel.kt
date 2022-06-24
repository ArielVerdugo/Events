package com.eventbrite.androidchallenge.ui.events

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class EventsViewModel@Inject constructor(private val eventUseCase: EventUseCase) : ViewModel(){

    private val _events = MutableLiveData<EventsDto>()
    val events: LiveData<EventsDto> get() = _events

    private val _isInternetError = MutableLiveData<Boolean>()
    val isInternetError: LiveData<Boolean> get() = _isInternetError

    private val _isServiceError = MutableLiveData<Boolean>()
    val isServiceError: LiveData<Boolean> get() = _isServiceError

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
        if (response != null && response.successful){
            _events.postValue(response.body)
            hideProgress()
        }else{
            //Todo algo que falle
            if (response.exception is UnknownHostException){
                // TODO: ERRRO INTERNET
                Log.d("tu hermana","tu rehermana")
                _isInternetError.postValue(true)
            }else{
                // Todo otro fallo
                Log.d("tu prima","tu prima")
                _isServiceError.postValue(true)
            }
            Log.d("aaa",response.toString())
            hideProgress()
        }


    }

}