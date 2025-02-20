package com.example.routes

import com.example.models.User
import com.example.services.UserService
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

import org.mindrot.jbcrypt.BCrypt
import java.time.Instant

fun Route.usersRoutes() {
    val userService = UserService()

    route("/users") {
        post("/register") {
            try {
                val user = call.receive<User>()
                val salt = BCrypt.gensalt()
                val hashedPassword = BCrypt.hashpw(user.password, BCrypt.gensalt())
                val newUser = user.copy(
                    password = hashedPassword,
                    salt = salt,
                    createdAt = Instant.now().toString()
                )
                userService.createUser(newUser)
                call.response.status(HttpStatusCode.Created)

            }   catch (e: Exception) {
                call.response.status(HttpStatusCode.BadRequest)
                print(e.stackTraceToString())
            }
        }
    }
}