package com.example

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class KVApplication

fun main(args: Array<String>) {
    runApplication<KVApplication>(*args)
}
