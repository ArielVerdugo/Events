package com.eventbrite.androidchallenge.data.events.model

import okhttp3.Response
import java.io.Closeable

class ResponseMock: Closeable {
    override fun close() {
    }

}