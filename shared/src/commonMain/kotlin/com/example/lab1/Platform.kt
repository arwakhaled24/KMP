package com.example.lab1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform