package org.example

import java.util.*

class ReadFile {
    companion object {
        @JvmStatic fun readFileAsStream(filename: String) =
            Objects.requireNonNull(Main::class.java.classLoader.getResource(filename)).openStream()!!
    }
}

