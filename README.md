# Library Management System (Java + MySQL + JDBC)

## Project Overview

The **Library Management System** is a backend Java application designed to manage books efficiently using a MySQL database. It demonstrates core backend development concepts such as CRUD operations, JDBC connectivity, and layered architecture.

This project simulates real-world library operations like adding books, viewing books, issuing books, returning books, and searching for books using a database-driven approach.

---

## Features

-  Add new books to the database  
-  View all books stored in the system  
-  Search books by ID  
-  Issue books (update status in database)  
-  Return books (update status in database)  
-  Input validation to prevent invalid data  
-  Persistent storage using MySQL database  
-  JDBC-based database connectivity  

---

##  Tech Stack

- Java (Core Java, OOP)
- MySQL (Database)
- JDBC (Database Connectivity)
- IntelliJ IDEA (IDE)

---

##  Key Concepts Used

- Object-Oriented Programming (Encapsulation, Classes, Objects)
- CRUD Operations (Create, Read, Update)
- PreparedStatement (SQL Injection Prevention)
- Exception Handling
- Layered Architecture (Main → Service → Database)
- Database Design & Relational Tables

---

##  Database Schema

```sql
CREATE DATABASE LibraryDB;

USE LibraryDB;

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    author VARCHAR(255),
    isIssued BOOLEAN DEFAULT FALSE
);
