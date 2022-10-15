package com.samoleproject

import RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

const val apiUrl = "https://api.spacexdata.com/v4/launches"

class Greeting {
    private val platform: Platform = getPlatform()
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    @Throws(Exception::class)
    suspend fun greeting(): String {
        val rockets: List<RocketLaunch> = httpClient.get(apiUrl).body()
        val lastSuccessLaunch = rockets.last { launch -> launch.isLaunchSuccess == true }
        return "Guess what it is! > ${platform.name.reversed()}!" +
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀"
    }
}