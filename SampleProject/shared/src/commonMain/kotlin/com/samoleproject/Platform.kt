package com.samoleproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform