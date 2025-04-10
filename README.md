# 🧾 Journal Backend API

A clean, modular, and secure backend system for managing personal or public journal entries. Built using **Java Spring Boot**, this project provides RESTful APIs for CRUD operations, user authentication,role based access control, caching using Redis — ready to integrate with web or mobile frontends.

---

- 🔐 **JWT-based Authentication**  
  Secure login and role-based access control

- 📝 **Journal Entry Management**  
  Create, update, delete, and retrieve entries with timestamps

- 🧠 **Caching with Spring Cache (e.g. Redis)**  
  Speeds up frequent reads and improves API response time
  
- 🧪 **Automated Testing**  
  Includes unit and integration tests with **JUnit** and **Mockito**

- ⚙️ **Clean Architecture**  
  Follows separation of concerns: Controller → Service → Repository

  - 🧾 **Structured Logging**  
  Application-wide logging for key events using **SLF4J + Logback**
---

## 🧰 Tech Stack

| Category         | Technology               |
|------------------|--------------------------|
| Language         | Java 17                  |
| Framework        | Spring Boot 3            |
| Security         | Spring Security, JWT     |
| Persistence      | Spring Data JPA          |
| Caching          | Spring Cache (Redis)     |
| Database         | MongoDB                  |
| Logging          | SLF4J, Logback           |
| Testing          | JUnit 5, Mockito         |
| Build Tool       | Maven                    |
