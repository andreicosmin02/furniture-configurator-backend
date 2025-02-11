# Furniture Configurator Backend

This is the backend for the **Furniture Configurator**, a system designed to help users arrange and order furniture based on their room dimensions. The backend is built using **Ktor**, a modern Kotlin framework for building scalable APIs, and uses **MongoDB Atlas** as the database.

## 🚀 Features

### ✅ Core Features
- **User Authentication** (JWT with refresh tokens & role-based access control)
- **Product Catalog API** (Fetch furniture items from MongoDB)
- **Shopping Cart API** (Add/remove items & manage user carts)
- **Order Processing API** (Place orders & track order status)
- **Secure API** (Rate limiting, CORS, and HTTPS encryption)
- **Deployable on AWS EC2 (Free Tier)**

### ✅ Installed Plugins
| Name | Description |
| ---------------------------- | ---------------------------------------------------------------- |
| [Routing](https://ktor.io/docs/routing.html) | Provides a structured routing DSL for defining API endpoints |
| [Content Negotiation](https://ktor.io/docs/content-negotiation.html) | Enables automatic JSON content conversion |
| [kotlinx.serialization](https://ktor.io/docs/serialization.html) | Handles JSON serialization using kotlinx.serialization |
| [Authentication](https://ktor.io/docs/authentication.html) | Implements JWT-based authentication and authorization |

---

## 🛠️ Building & Running

To build and run the project, use the following commands:

| Task                          | Description                                                      |
| ----------------------------- | ---------------------------------------------------------------- |
| `./gradlew test`              | Run unit tests                                                   |
| `./gradlew build`             | Build the project                                                |
| `./gradlew run`               | Run the Ktor server locally                                      |
| `buildFatJar`                 | Build an executable JAR with all dependencies included          |
| `buildImage`                  | Build a Docker image for deployment                             |
| `publishImageToLocalRegistry` | Publish the Docker image locally                                |
| `runDocker`                   | Run using the local Docker image                               |

### 🔹 Running Locally
Once the server starts, you should see:
```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

You can now send API requests to `http://localhost:8080/`.

---

## 📌 Next Steps
- [ ] Connect to MongoDB Atlas for database operations.
- [ ] Implement JWT authentication & authorization.
- [ ] Create API endpoints for product listing, cart management, and orders.
- [ ] Deploy the backend on AWS Free Tier EC2 with SSL encryption.

---

## 📄 Documentation & Resources
- [Ktor Documentation](https://ktor.io/docs/home.html)
- [MongoDB Atlas](https://www.mongodb.com/atlas/database)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [AWS Free Tier](https://aws.amazon.com/free/)
