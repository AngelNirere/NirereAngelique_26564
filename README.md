# RESTful API Assignment

A Spring Boot microservice application for product management.

## Features

- CRUD operations for Product management
- RESTful API endpoints
- Data validation

## Technologies

- Java 17
- Spring Boot 4.0.2
- Spring Data JPA
- Maven

## API Endpoints

### Product Management

- `POST /api/product/addProduct` - Add new product
- `GET /api/product` - Get all products
- `GET /api/product/{id}` - Get product by ID
- `PUT /api/product/{id}` - Update product
- `DELETE /api/product/{id}` - Delete product

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Sample Product JSON

```json
{
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 1200.00,
  "category": "Electronics",
  "stockQuantity": 10,
  "brand": "Dell"
}
```
