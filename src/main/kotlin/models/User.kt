package com.example.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("_id")
    @Contextual val id: Long? = null,
    val name: String,
    val email: String,
    @SerialName("password")
    val password: String,
    val salt: String? = null,
    val roles: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
)
