package com.eventbrite.androidchallenge.data.events.model

import java.io.InputStream

class InputStreamMock: InputStream() {
    override fun read(): Int {
        return 1
    }
}