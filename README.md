<div align="center">

<img src="https://cdn-icons-png.flaticon.com/512/4712/4712109.png" width="100" />

# SmartAssist — AI Chatbot System

**A production-ready AI chatbot backend powered by Spring Boot & Groq LLM**

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-brightgreen?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![Groq](https://img.shields.io/badge/Groq-LLaMA%203-blue?style=flat-square)](https://groq.com)
[![Render](https://img.shields.io/badge/Deployed-Render-purple?style=flat-square&logo=render)](https://smartassist-ai-chatbot.onrender.com)
[![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)](LICENSE)

[🌐 Live Demo](https://smartassist-ai-chatbot.onrender.com) • [📖 API Docs](#-api-reference) • [🚀 Quick Start](#-getting-started)

</div>

---

## 📌 Overview

SmartAssist is a full-stack AI chatbot system built from scratch using **Java & Spring Boot**. It integrates with the **Groq LLM API (LLaMA 3)** to generate real-time intelligent responses and persists complete conversation history using **Spring Data JPA + H2 Database**.

The project follows a clean **MVC layered architecture** — making the codebase modular, testable, and production-ready.

> Built to demonstrate real-world backend engineering skills — not just a tutorial project.

---

## ✨ Features

- 🤖 &nbsp;**AI-Powered Responses** — Real-time answers via Groq LLaMA 3
- 💬 &nbsp;**Conversation History** — Full chat history stored and retrievable by session
- 🔐 &nbsp;**Secure Configuration** — API keys managed via environment variables
- 🌐 &nbsp;**Integrated Frontend** — Animated chat UI served directly by Spring Boot
- 🏗️ &nbsp;**Clean Architecture** — MVC pattern with Controller → Service → Repository
- ⚠️ &nbsp;**Global Exception Handling** — Consistent, clean error responses
- 🐳 &nbsp;**Dockerized** — Containerized for easy deployment anywhere
- ☁️ &nbsp;**Cloud Deployed** — Live on Render with auto-deploy on every push

---

## 🛠️ Tech Stack

| Layer | Technology | Purpose |
|---|---|---|
| Language | Java 17 | Core backend language |
| Framework | Spring Boot 4.0 | Application framework |
| ORM | Spring Data JPA + Hibernate | Database interaction |
| Database | H2 (File Mode) | Persistent chat storage |
| AI Integration | Groq API (LLaMA 3) | Intelligent response generation |
| Frontend | HTML + CSS + JavaScript | Chat UI |
| Build Tool | Maven | Dependency management |
| Containerization | Docker | Deployment packaging |
| Cloud | Render | Hosting & auto-deploy |
| Testing | Postman | API validation |
| Version Control | Git + GitHub | Source control |

---

## 🏗️ Architecture
```
┌─────────────────────────────────────────┐
│              Client (Browser)            │
│          http://localhost:8080           │
└──────────────────┬──────────────────────┘
                   │ HTTP Request
                   ▼
┌─────────────────────────────────────────┐
│           ChatController.java            │
│         @RestController /api/chat        │
└──────────────────┬──────────────────────┘
                   │
                   ▼
┌─────────────────────────────────────────┐
│            ChatService.java              │
│      Business Logic + Groq API Call      │
└──────────┬───────────────────┬──────────┘
           │                   │
           ▼                   ▼
┌──────────────────┐  ┌────────────────────┐
│ ChatRepository   │  │   Groq LLM API     │
│ Spring Data JPA  │  │   LLaMA 3 Model    │
└────────┬─────────┘  └────────────────────┘
         │
         ▼
┌──────────────────┐
│   H2 Database    │
│  chat_messages   │
└──────────────────┘
```

### Project Structure
```
src/
├── main/
│   ├── java/com/smartassist/
│   │   ├── SmartassistApplication.java      # Entry point
│   │   ├── controller/
│   │   │   └── ChatController.java          # REST endpoints
│   │   ├── service/
│   │   │   └── ChatService.java             # Core business logic
│   │   ├── repository/
│   │   │   └── ChatRepository.java          # DB queries
│   │   ├── model/
│   │   │   └── ChatMessage.java             # JPA entity
│   │   ├── dto/
│   │   │   ├── ChatRequest.java             # Request DTO
│   │   │   └── ChatResponse.java            # Response DTO
│   │   └── exception/
│   │       └── GlobalExceptionHandler.java  # Error handling
│   └── resources/
│       ├── static/
│       │   └── index.html                   # Chat frontend
│       └── application.properties           # Config
└── test/
    └── SmartassistApplicationTests.java
```

---

## 📡 API Reference

### `POST /api/chat`
Send a message and receive an AI-generated response.

**Request Body**
```json
{
  "sessionId": "user123",
  "message": "What is Spring Boot?"
}
```

**Response**
```json
{
  "sessionId": "user123",
  "reply": "Spring Boot is an open-source Java framework that simplifies...",
  "timestamp": "2026-03-13T06:44:51.068914700"
}
```

---

### `GET /api/chat/history/{sessionId}`
Retrieve full conversation history for a session.

**Response**
```json
[
  {
    "id": 1,
    "sessionId": "user123",
    "userMessage": "What is Spring Boot?",
    "botResponse": "Spring Boot is an open-source Java framework...",
    "timestamp": "2026-03-13T06:44:51"
  }
]
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- Groq API Key — [Get it free here](https://console.groq.com)

### 1. Clone the repository
```bash
git clone https://github.com/karanaawla1/SmartAssist-AI-Chatbot.git
cd SmartAssist-AI-Chatbot
```

### 2. Configure environment
Create `src/main/resources/application.properties`:
```properties
spring.application.name=smartassist

spring.datasource.url=jdbc:h2:file:./smartassist-db
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true

groq.api.key=YOUR_GROQ_API_KEY_HERE
groq.api.url=https://api.groq.com/openai/v1/chat/completions
```

### 3. Run the application
```bash
./mvnw spring-boot:run
```

### 4. Open in browser
```
http://localhost:8080
```

---

## 🐳 Docker
```bash
# Build image
docker build -t smartassist .

# Run container
docker run -p 8080:8080 \
  -e GROQ_API_KEY=your_key \
  smartassist
```

---

## 🔮 Future Improvements

- [ ] Switch to PostgreSQL for production database
- [ ] Add user authentication (JWT)
- [ ] Implement conversation context (multi-turn memory)
- [ ] Add rate limiting per session
- [ ] React frontend for better UX
- [ ] Unit & integration tests

---

## 👨‍💻 Author

<div align="center">

**Karan Aawla**

[![GitHub](https://img.shields.io/badge/GitHub-karanaawla1-black?style=flat-square&logo=github)](https://github.com/karanaawla1)

</div>

---

<div align="center">

⭐ **If you found this helpful, please star the repository!** ⭐

</div>
