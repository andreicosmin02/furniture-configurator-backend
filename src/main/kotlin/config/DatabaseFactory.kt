package com.example.config

import com.mongodb.*
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import org.bson.BsonDocument
import org.bson.BsonInt64
import org.bson.codecs.configuration.CodecProvider
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider


object DatabaseFactory {
    private lateinit var mongoClient: MongoClient
    lateinit var database: MongoDatabase

    fun init() {
        val mongodbDatabaseUrl = System.getenv("MONGODB_DATABASE_URL")

        val serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build()

        // Can't find a codec for CodecCacheKey{clazz=class com.example.models.User, types=null}.
        // Solve:
        val pojoCodecProvider: CodecProvider = PojoCodecProvider.builder().automatic(true).build()
        val pojoCodecRegistry: CodecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(pojoCodecProvider))

        val settings = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .applyConnectionString(ConnectionString(mongodbDatabaseUrl))
            .serverApi(serverApi)
            .build()

        mongoClient = MongoClients.create(settings)
        database = mongoClient.getDatabase("FurnitureStore")
        try {
            val command = BsonDocument("ping", BsonInt64(1))
            val commandResult = database.runCommand(command)
            println("Pinged your deployment. You successfully connected to MongoDB.")
        } catch (me: MongoException) {
            System.err.println(me.message)
        }
    }

    fun close() {
        mongoClient.close()
    }
}