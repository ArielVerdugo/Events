package com.eventbrite.androidchallenge.data.events.model

import retrofit2.Response
import java.lang.Exception


data class ServiceResponse<T>(
    val data: Response<T>?,
    val exception: Exception?,
) {

    companion object{
        fun<T>isSuccess(response: Response<T>): ServiceResponse<T>{
            return ServiceResponse(
                data = response,
                exception = null,
            )
        }

        fun<T>failure(response: Response<T>?,exception: Exception?):ServiceResponse<T>{
            return ServiceResponse(
                data = response,
                exception = exception,
            )
        }
    }

    val successful: Boolean get() = if (this.data != null) this.data.isSuccessful else false
    val body: T get() = this.data!!.body()!!
}