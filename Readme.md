# GST Billing Application (Spring Boot Backend)

This is a backend REST API developed using Spring Boot for managing GST billing operations.

## Features
- Business registration with GST validation
- Product management with GST slabs
- Invoice generation with GST calculation (CGST, SGST, IGST)
- Standardized API responses
- Global exception handling
- Pagination support

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Postman

## GST Rules Implemented
- Same state: CGST + SGST
- Different state: IGST

## API Testing
APIs tested using Postman.

## Project Structure
controller | service | repository | entity | dto | exception | util