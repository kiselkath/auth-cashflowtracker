# Auth Service — Smart Expense Project

This is the **Authentication Service** microservice for the Smart Expense project.  
It handles **user login, JWT issuance, and validation** for other backend services, which run as resource servers.

---

## 🚀 Tech Stack

- **Project**: Maven, Java 17
- **Spring Boot**: 3.5.4

### Dependencies
- **Spring Web** — provides the web layer for REST endpoints.
- **Spring Security** — authentication and authorization framework.
- **OAuth2 Resource Server** — validates JWTs for secure resource access.
- **Validation** — for request input validation (DTOs, login forms, etc.).
- **Spring Boot Actuator** — monitoring and health checks.

---

## 📂 Project Purpose
- Authenticate users and issue **JWT tokens** for `USER` and `ADMIN` roles.
- Validate JWTs for other microservices acting as **resource servers**.
- Ensure request data integrity using Spring Validation.
- Expose **health and monitoring endpoints** via Actuator.
- Support secure, standardized authentication across the Smart Expense microservices ecosystem.
