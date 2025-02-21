package com.example

import com.example.config.DatabaseFactory
import com.example.config.configureRouting
import com.example.config.configureSecurity
import com.example.config.configureSerialization
import com.example.models.TokenConfig
import com.example.services.JwtTokenService
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init()
    val tokenService = JwtTokenService()
    val tokenConfig = TokenConfig(
        issuer = environment.config.property("jwt.issuer").getString(),
        audience = environment.config.property("jwt.audience").getString(),
        expirationTimeInSeconds = 365L * 1000L * 60L * 60L * 24L,
        secretKey = System.getenv("JWT_SECRET_KEY")
    )

    configureSecurity(tokenConfig)
    configureRouting()
    configureSerialization()

    monitor.subscribe(ApplicationStopped) {
        DatabaseFactory.close()
    }
}
