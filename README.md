# 📦 Spring Boot Order Microservice (with RestTemplate & Spring Data JPA)

This project is an **Order Microservice** built using **Spring Boot**, **Spring Data JPA**, and **RestTemplate** to communicate with a separate **User Service**.  
It demonstrates how to perform CRUD operations locally and make REST API calls to another service in a microservice environment.

---

## 🚀 Features

✅ CRUD operations for Order entity  
✅ Uses **Spring Data JPA (CrudRepository)** for database operations  
✅ Inter-service communication using **RestTemplate**  
✅ Calls User Service (on port `8081`) to get and create users  
✅ Clean layered architecture — Controller → Service → Repository  
✅ Exception handling and DTO (Data Transfer Object) usage

---
## 🧱 Project Structure

src/main/java/com/example/demo/
│
├── config/
│ └── RestTemplateConfig.java → Defines RestTemplate bean
│
├── controller/
│ └── OrderController.java → REST endpoints for Order & User communication
│
├── dto/
│ └── UserDTO.java → Data Transfer Object for User details
│
├── model/
│ └── OrderModel.java → Entity class mapped to 'order' table
│
├── Repository/
│ └── OrderRepository.java → DAO layer using Spring Data JPA
│
└── service/
└── Orderservice.java → Business logic + RestTemplate API calls

pgsql
Copy code

---

## ⚙️ Technologies Used

| Component | Technology |
|------------|-------------|
| **Language** | Java 17+ |
| **Framework** | Spring Boot 3.x |
| **ORM** | Spring Data JPA (Hibernate) |
| **Database** | MySQL / H2 (configurable) |
| **Inter-service Communication** | RestTemplate |
| **Build Tool** | Maven |
| **IDE** | Spring Tool Suite (STS) |

---

## 🧩 API Endpoints

### 🛒 Order APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/orders` | Get all orders |
| `GET` | `/order/{uid}` | Get all orders by user ID |
| `POST` | `/order` | Create new order |

### 👤 User APIs (via RestTemplate)

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/users` | Fetch all users from User Service |
| `POST` | `/user` | Create a new user in User Service |

---

## 🧠 Example Request (Order Creation)
```bash
POST /order
Content-Type: application/json

{
  "status": "Delivered",
  "itemname": "Laptop",
  "uid": 1
}
Response:

json
Copy code
{
  "oid": 10,
  "status": "Delivered",
  "itemname": "Laptop",
  "uid": 1
}

## 🧱 Project Structure

