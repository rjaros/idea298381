package com.example

interface IPingService {
    suspend fun ping(message: String): String
}
