package com.heavycoffee.kmpbase

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform