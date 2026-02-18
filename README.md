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
### 1. Get All Products
**Query:**
```sql
SELECT * FROM product;
```

**Result:** Shows 3 products (TechSound Headphones, iPhone 15 Pro, Nike Air Max)

![PostgreSQL All Products]![Image](https://github.com/user-attachments/assets/2280ede5-ab62-40bc-a979-36e68104b90e)

### 4. Filter Products by Brand
**Query:**
```sql
SELECT * FROM product 
WHERE brand = 'TechSound'
ORDER BY price;
```


### 3. Update Stock Quantity
**Query:**
```sql
UPDATE product 
SET stock_quantity = stock_quantity - 1 
WHERE product_id = 3;
```

**Result:** UPDATE 1 - Query returned successfully in 175 msec

![PostgreSQL Update Stock]<img width="545" height="310" alt="Image" src="https://github.com/user-attachments/assets/427b56df-5e46-4385-930a-4bd830865366" />
### 2. Get Product by ID
**Query:**
```sql
SELECT * FROM product WHERE product_id = 3;
```

**Result:** Returns iPhone 15 Pro details
- Price: $999.99
- Stock: 25 units
- Category: Mobile Phones

<img width="787" height="395" alt="Image" src="https://github.com/user-attachments/assets/277e052d-403d-4fbf-aaed-a748a5efe939" />
---

### 4. Filter Products by Brand
**Query:**
```sql
SELECT * FROM product 
WHERE brand = 'TechSound'
ORDER BY price;
```

**Result:** Returns TechSound headphones ($89.99)

![PostgreSQL Filter by Brand]<img width="788" height="353" alt="Image" src="https://github.com/user-attachments/assets/8772fb0d-ebc4-402f-954c-53615a966b00" />

---

### 5. Get Products by Price Range
**Query:**
```sql
SELECT * FROM product 
WHERE price BETWEEN 100 AND 500;
```

**Result:** Returns Nike Air Max ($129.99)

![PostgreSQL Price Range]<img width="777" height="329" alt="Image" src="https://github.com/user-attachments/assets/3130bb96-58db-4ff4-af3e-aaab02fb3aaa" />

## 📝 Product Model

```java
{
  "id": Long,
  "name": String (required, unique),
  "description": String,
  "price": Double (required),
  "category": String,
  "stockQuantity": Integer,
  "brand": String
}
```

## 👨‍💻 Author

**Nirere Angelique**
- Student ID: 26564

Contributions, issues, and feature requests are welcome!

---

⭐ **Star this repository if you find it helpful!**

