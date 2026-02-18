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
 🧪 API Testing with Postman

### 1. Create Product (POST)
**Endpoint:** `POST http://localhost:8081/api/product/addProduct`

**Request Body:**
```json
"description": "Latest Apple smartphone",
  "price": 999.99,
  "category": "Electronics",
  "brand": "Apple",
  "stockQuantity": 25
}
```

**Response:** `201 Created`
```json
"Product added successfully"
```

<img width="914" height="674" alt="Image" src="https://github.com/user-attachments/assets/ec2e8960-cec0-4c54-b538-fe3026f97e88" />
  "name": "iPhone 15",
  

---

### 2. Get All Products (GET)
**Endpoint:** `GET http://localhost:8081/api/product`

**Response:** `200 OK`
```json
[
  {
    "brand": "Dell",
    "category": "Electronics",
    "description": "Gaming laptop",
    "id": 1,
    "name": "Laptop",
    "price": 1200.0,
    "stockQuantity": 10
  }
]
```

<img width="843" height="394" alt="Image" src="https://github.com/user-attachments/assets/96727d28-65ef-4626-9732-9a9761fe7b7a" />

---

### 3. Get Product by ID (GET)
**Endpoint:** `GET http://localhost:8081/api/product/1`

**Response:** `200 OK`
```json
{
  "brand": "Dell",
  "category": "Electronics",
  "description": "Gaming laptop",
  "id": 1,
  "name": "Laptop",
  "price": 1200.0,
  "stockQuantity": 10
}
```

<img width="918" height="637" alt="Image" src="https://github.com/user-attachments/assets/bb74f74a-9bf0-4d2e-b3e9-7ee0068fc2cd" />

---

### 4. Update Product (PUT)
**Endpoint:** `PUT http://localhost:8081/api/product/1`

**Request Body:**
```json
{
  "brand": "Dell",
  "category": "Electronics",
  "description": "Gaming laptop",
  "id": 1,
  "name": "Laptop",
  "price": 1200.0,
  "stockQuantity": 10
}
```

**Response:** `200 OK`
```json
"Product updated successfully"
```

<img width="920" height="678" alt="Image" src="https://github.com/user-attachments/assets/3637baf2-66e8-443a-88cf-0d4d2eb432e9" />

---

### 5. Delete Product (DELETE)
**Endpoint:** `DELETE http://localhost:8081/api/product/1`

**Response:** `200 OK`
```json
"Product deleted successfully"
```

<img width="932" height="643" alt="Image" src="https://github.com/user-attachments/assets/03a13ab0-9279-4399-97c4-10ebffa6bc6d" />

---

## 🗄 Database Configuration
### 1. Get All Products
**Query:**
```sql
SELECT * FROM product;
![PostgreSQL All Products]![Image](https://github.com/user-attachments/assets/ac71b5e3-fb66-43f6-a017-386f38154a99)
### 2. Get Product by ID
**Query:**
```sql
SELECT * FROM product WHERE product_id = 3;
![PostgreSQL Product by ID]<img width="787" height="395" alt="Image" src="https://github.com/user-attachments/assets/7d8bb040-ce5c-439f-82c7-e1f889f87b6f" />
