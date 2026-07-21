#  Smart Event Ticket Booking System

A full-stack Event Ticket Booking application that allows users to browse events, book tickets, make secure online payments, and receive AI-powered event recommendations. The project is being developed using **Spring Boot** for the backend and **HTML, CSS, and JavaScript** for the frontend.

---

##  Project Status

 **Currently Under Development**

This project is being built incrementally with regular feature additions and GitHub updates.

---

##  Features

### User

- User Registration & Login
- Secure Authentication using JWT
- Browse Available Events
- Search & Filter Events
- Book Event Tickets
- View Booking History
- Update Profile

###  Admin

- Add New Events
- Update Event Details
- Delete Events
- Manage Users
- View All Bookings
- Dashboard with Booking Statistics

---

##  Tech Stack

### Backend

- Java 
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- JWT Authentication
- Maven

### Database

- MySQL

### Frontend

- HTML
- CSS
- JavaScript

### Tools

- IntelliJ IDEA
- VS Code
- Postman
- Git
- GitHub

### Integrations (Planned)

- Razorpay Payment Gateway
- AI Chatbot API

---

##  Database

### Main Tables

- User
- Event
- Booking
- Payment

---

##  Development Milestones

###  Phase 1: Project Setup
 Project Setup|Initialized Spring Boot Project| Configured MySQL Database| 
 Created Project Structure|Configured Maven Dependencies | Tested Database Connection

 ###  Phase 2: DataBase Design
  Design Event ,Booking,User Entities |Created Entity Relationships| Generate Database Tables

 ###  Phase 3: CRUD API'S Integration
 #### Phase 3.1
 Started with the User module.Built the full layer stack: Repository → Service → Controller.
  #### Phase 3.2
  Integrated Events module and also tested API's using Postman
  #### Phase 3.3
 Integrated Bookings module and also tested API's using Postman
 Booking is different from User/Event — the request needs to reference an existing User and Event by their IDs, not create new ones. So we fetch the actual User and Event from the database first, using their repositories, then attach them to the Booking.

###  Phase 4: Validation
Right now nothing stops someone from POSTing an empty name, an invalid email, or totalSeats: -5. Bean Validation (jakarta.validation) fixes that by adding annotations directly on entity fields, then a single @Valid in the controller triggers the checks automatically.
Annotations like @NotBlank, @Email, @Min go on entity fields.
@Valid goes in the controller method parameter (@Valid @RequestBody User user).


 ---

## 📂 Project Structure

```text
event-booking-system
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── config
│   │   │   ├── controller
│   │   │   ├── dto
│   │   │   ├── entity
│   │   │   ├── exception
│   │   │   ├── repository
│   │   │   ├── security
│   │   │   ├── service
│   │   │   └── util
│   │   └── resources
│   └── test
└── pom.xml
```








