package com.eventbrite.androidchallenge.data.events.model

import com.eventbrite.androidchallenge.utils.Constants
import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.BufferedSource

class ResponseBodyMock: ResponseBody() {
    override fun contentType(): MediaType? {
        return null
    }

    override fun contentLength(): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun source(): BufferedSource {
        return BufferdMock()
    }
}