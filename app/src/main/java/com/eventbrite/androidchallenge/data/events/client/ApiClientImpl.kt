package com.eventbrite.androidchallenge.data.events.client

import com.eventbrite.androidchallenge.data.events.EventsService
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import com.eventbrite.androidchallenge.data.events.model.ServiceResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import kotlin.Exception

class ApiClientImpl @Inject constructor(private val apiClient: EventsService): ApiClient{
    override suspend fun getEvents(): ServiceResponse<EventsDto> {
        //return withContext(Dispatchers.IO){
          //  val response = apiClient.listOrganizerEvents()
            //response
        //}

        return withContext(Dispatchers.IO){
             apiCall { apiClient.listOrganizerEvents() }
        }
    }

    private inline fun<T> apiCall(apiCall:() -> Response<T>): ServiceResponse<T>{
        return try {
            ServiceResponse.isSucces(apiCall.invoke())
        }catch (e:Exception){
            ServiceResponse.failure(e)
        }
    }
}