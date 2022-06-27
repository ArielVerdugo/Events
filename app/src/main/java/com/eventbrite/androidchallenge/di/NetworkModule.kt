package com.eventbrite.androidchallenge.di

import com.eventbrite.androidchallenge.data.events.EventsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //Ping interval seteado 1 segundo por bug de okhhtp
    //https://github.com/square/okhttp/issues/3146
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.evbqaapi.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().pingInterval(1,TimeUnit.SECONDS).build())
            .build()
    }

    @Provides
    @Singleton
    fun provideEventsService(retrofit: Retrofit): EventsService{
        return retrofit.create(EventsService::class.java)
    }
}