package com.example.services

import com.example.config.DatabaseFactory
import com.example.models.User
import org.bson.types.ObjectId
import org.litote.kmongo.eq
import org.litote.kmongo.findOneById
import org.litote.kmongo.getCollection
import org.litote.kmongo.updateOne

class UserService {
    private var collection = DatabaseFactory
        .database
        .getCollection<User>("users")

    suspend fun createUser(user: User) {
        collection.insertOne(user)
    }

    suspend fun getUserById(id: Long): User? {
        return collection.findOneById(User::id eq id)
    }

    suspend fun getUserByEmail(email: String): User? {
        return collection.findOneById(User::email eq email)
    }

    suspend fun getAllUsers(): List<User> {
        return collection.find().toList()
    }

    suspend fun updateUserById(id: Long, user: User): Boolean {
        val updateResult = collection.updateOne(User::id eq id, user)
        return updateResult.matchedCount > 0
    }

    suspend fun deleteUserById(id: Long): Boolean {
        val deleteResult = collection.deleteOne(User::id eq id)
        return deleteResult.deletedCount > 0
    }
}