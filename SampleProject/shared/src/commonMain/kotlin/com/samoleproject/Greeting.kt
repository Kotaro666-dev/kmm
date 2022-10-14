package com.samoleproject

class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): String {
        return "Hello World, ${platform.name}!"
    }
}