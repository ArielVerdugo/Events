package com.eventbrite.androidchallenge.data.events.model

import retrofit2.Response
import java.lang.Exception


data class ServiceResponse<T>(
    val status: Status,
    val data: Response<T>?,
    val exception: Exception?,
) {

    companion object{
        fun<T>isSucces(data: Response<T>): ServiceResponse<T>{
            return ServiceResponse(
                status = Status.Success,
                data = data,
                exception = null,
            )
        }

        fun<T>failure(exception: Exception):ServiceResponse<T>{
            return ServiceResponse(
                status = Status.Failure,
                data = null,
                exception = exception,
            )
        }
    }

    sealed class Status{
        object Success: Status()
        object Failure: Status()
    }

    val failed: Boolean get() = this.status == Status.Failure
    val successful: Boolean get() = !failed && this.data?.isSuccessful == true
    val body: T get() = this.data!!.body()!!
}