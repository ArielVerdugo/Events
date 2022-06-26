package com.eventbrite.androidchallenge.data.events.model

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.BufferedSource

class ResponseBodyMock: ResponseBody() {
    override fun contentType(): MediaType? {
        return null
    }

    override fun contentLength(): Long {
        return 123
    }

    override fun source(): BufferedSource {
        return BufferdMock()
    }
}