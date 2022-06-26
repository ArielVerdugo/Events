package com.eventbrite.androidchallenge.ui.events

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.eventbrite.androidchallenge.data.events.model.*
import com.eventbrite.androidchallenge.usecase.EventUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response
import java.net.UnknownHostException
import java.util.*

@ExperimentalCoroutinesApi
class EventsViewModelTest{

    @RelaxedMockK
    private lateinit var eventUseCase: EventUseCase

    private lateinit var eventViewModel: EventsViewModel



    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        eventViewModel = EventsViewModel(eventUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at first time, get all events and set values`() = runTest {
        //Given
        val events = EventsDto(listOf(EventDto("1234","launch",Date(),"perfect lunch","complete",null)))

        val r1: Response<*> = Response.success(events)

        val response = ServiceResponse.isSuccess(r1)

        coEvery { eventUseCase.executeGetEvents()} returns response as ServiceResponse<EventsDto>

        //WHEN
        eventViewModel.getEvents()


        assert(eventViewModel._events.value == events)

    }

    @Test
    fun `when internet connection fails set view`() = runTest {
        //Given
        val exception = UnknownHostException()

        val responseBodyMock = ResponseBodyMock()

        val r1: Response<*> = Response.error<ResponseBodyMock>(400,responseBodyMock)

        val response = ServiceResponse.failure(r1,exception)

        coEvery { eventUseCase.executeGetEvents()} returns response as ServiceResponse<EventsDto>

        //WHEN
        eventViewModel.getEvents()


        assert(eventViewModel._isInternetError.value == true)

    }


    @Test
    fun `when service fails set view`() = runTest {
        //Given

        val responseBodyMock = ResponseBodyMock()

        val r1: Response<*> = Response.error<ResponseBodyMock>(400,responseBodyMock)

        val response = ServiceResponse.failure(r1,null)

        coEvery { eventUseCase.executeGetEvents()} returns response as ServiceResponse<EventsDto>

        //WHEN
        eventViewModel.getEvents()


        assert(eventViewModel._isServiceError.value == true)

    }

}