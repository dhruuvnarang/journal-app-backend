# 🧾 Journal Backend API

A modular and secure backend for managing personal journal entries. Built with **Java Spring Boot**, it provides RESTful APIs for journal CRUD, JWT authentication, Google OAuth login, role-based access control, Redis caching, and weekly sentiment reports delivered through Kafka. Ready to integrate with web or mobile frontends.

---

- 🔐 **JWT Authentication & Google OAuth**
  Signup/login with JWT tokens, plus Google sign-in via `/auth/google/callback`

- 📝 **Journal Entry Management**
  Create, update, delete, and retrieve entries with timestamps

- 🧠 **Caching with Redis**
  Speeds up frequent reads and improves API response time

- 📬 **Weekly Sentiment Pipeline**
  Scheduled sentiment reports published to Kafka, consumed and emailed, with direct email fallback

- 📖 **Swagger / OpenAPI Docs**
  Interactive API documentation with bearer-token support

- 🧪 **Automated Testing**
  Unit and integration tests with **JUnit 5** and **Mockito**

- ⚙️ **Clean Architecture**
  Separation of concerns: Controller → Service → Repository

- 🧾 **Structured Logging**
  Application-wide logging using **SLF4J + Logback**

---

## 🧰 Tech Stack

| Category       | Technology                          |
|----------------|-------------------------------------|
| Language       | Java 21                             |
| Framework      | Spring Boot 3.4                     |
| Security       | Spring Security, JWT (JJWT), OAuth2 |
| Database       | MongoDB                             |
| Caching        | Spring Cache (Redis)                |
| Messaging      | Apache Kafka (Spring Kafka)         |
| API Docs       | springdoc-openapi (Swagger UI)      |
| Logging        | SLF4J, Logback                      |
| Testing        | JUnit 5, Mockito                    |
| Build Tool     | Maven                               |

---

## ⚙️ Configuration

Secrets are read from environment variables (see `src/main/resources/application.yml`):

| Variable               | Purpose                                   |
|------------------------|-------------------------------------------|
| `JWT_SECRET`           | JWT signing key (at least 32 characters)  |
| `GOOGLE_CLIENT_ID`     | Google OAuth client ID                    |
| `GOOGLE_CLIENT_SECRET` | Google OAuth client secret                |
| `MONGODB_URI`          | MongoDB connection string                 |
| `REDIS_HOST`           | Redis host                                |
| `REDIS_PASSWORD`       | Redis password                            |
| `JAVA_EMAIL`           | SMTP sender address                       |
| `JAVA_EMAIL_PASSWORD`  | SMTP app password                         |
| `KAFKA_SERVERS`        | Kafka bootstrap servers                   |
| `WEATHER_API_KEY`      | Weather API key                           |

---
