package com.example.models

data class TokenConfig(
    val issuer: String,
    val audience: String,
    val expirationTimeInSeconds: Long,
    val secretKey: String
)
