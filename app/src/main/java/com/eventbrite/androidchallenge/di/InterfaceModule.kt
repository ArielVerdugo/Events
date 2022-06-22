package com.eventbrite.androidchallenge.di

import com.eventbrite.androidchallenge.data.events.client.ApiClient
import com.eventbrite.androidchallenge.data.events.client.ApiClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceModule {
    @Binds
    abstract fun provideApiClientInterface(characterApiClientImpl: ApiClientImpl):ApiClient
}