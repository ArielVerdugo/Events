package com.eventbrite.androidchallenge.data.events.model

import com.eventbrite.androidchallenge.utils.Constants
import java.io.InputStream

class InputStreamMock: InputStream() {
    override fun read(): Int {
        return Constants.INT_MOCK_VALUE
    }
}