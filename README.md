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

![Add Product](screenshots/add-product.png){
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

![Get All Products](screenshots/get-all-products.png)

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

![Get Product by ID](screenshots/get-product-by-id.png)

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

![Update Product](screenshots/update-product.png)

---

### 5. Delete Product (DELETE)
**Endpoint:** `DELETE http://localhost:8081/api/product/1`

**Response:** `200 OK`
```json
"Product deleted successfully"
```

![Delete Product](screenshots/delete-product.png)

---

## 🗄 Database Configuration

### H2 Console (Development)
Access H2 database console at: `http://localhost:8081/h2-console`

**Connection Details:**
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** `password`

### Sample Data
The application automatically loads sample products on startup:
- Laptop (Dell) - $1200.00
- Mouse (Logitech) - $25.00

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
- GitHub: [@NirereAngelique_26564](https://github.com/NirereAngelique_26564)
- Student ID: 26564

## 📄 License

This project is licensed under the MIT License.

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

⭐ **Star this repository if you find it helpful!**
