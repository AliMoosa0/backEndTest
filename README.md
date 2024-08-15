# Employee Management Microservice

## Overview

This is a Java Spring Boot microservice for managing employee data. The microservice provides RESTful APIs to create, retrieve, and query employee records. Data is stored in a MongoDB database.

## Requirements

- Java 8 or higher
- Spring Boot
- MongoDB
- Postman or similar API testing tool

## Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/employee-management-microservice.git
   cd employee-management-microservice

2. **Configure MongoDB 1:**
   create a collection called Employee and insert the data to it 

   **DataBase JSON:**
[Employees.Employee.json](https://github.com/user-attachments/files/16626487/Employees.Employee.json)

   
3. **Configure MongoDB 2:**

Ensure MongoDB is running locally or use a cloud instance. Update the application.yml file with your MongoDB connection details:
```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017
      database: Employees
```
Replace mongodb://localhost:27017 with your MongoDB connection URI if you're using a cloud service.



