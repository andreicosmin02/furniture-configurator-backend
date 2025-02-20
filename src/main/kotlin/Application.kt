package com.example

import com.example.config.DatabaseFactory
import com.example.config.configureRouting
import com.example.config.configureSecurity
import com.example.config.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    configureSecurity()
    DatabaseFactory.init()
    configureRouting()
    configureSerialization()

    monitor.subscribe(ApplicationStopped) {
        DatabaseFactory.close()
    }
}
