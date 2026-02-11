Student names: Nirere Angelique  
student ID: 26564  
 [restFull_api_26564](https://github.com/NirereAngelique_26564/restFull_api_26564)
Table of Contents
 [Question 1 – Library Management API](#question-1--library-management-api)
  - [Question 2 – Student Registration API](#question-2--student-registration-api)
  - [Question 3 – Restaurant Menu API](#question-3--restaurant-menu-api)
  - [Question 4 – E-commerce Product API](#question-4--e-commerce-product-api)
  - [Question 5 – Task Management API](#question-5--task-management-api)
  - [Bonus – User Profile API](#bonus--user-profile-api)

  - 📖 Project Overview

This project contains **6 RESTful APIs** built with **Spring Boot** as part of a Web Technologies assignment. Each API demonstrates different REST concepts including CRUD operations, query parameters, path variables, pagination, and custom response wrappers.

Project Structure

restFull_api_26564/
├── question1_librarymanagementapi/        # Question 1 - Library Management
├── question2_student_registration/        # Question 2 - Student Registration
│   └── question2_student_registration/
├── question3_restaurant_api/              # Question 3 - Restaurant Menu
│   └── question3_restaurant_api/
├── question4_ecommerce_api/               # Question 4 - E-commerce Products
│   └── question4_ecommerce_api/
├── question5_task_api/                    # Question 5 - Task Management
│   └── question5_task_api/
├── bonus_userapi/                         # Bonus - User Profiles
│   └── bonus_userapi/
└── README.md
### Question 1 – Library Management API

**Base URL:** `http://localhost:8080/api/books`

| Method | Endpoint | Description |
|:-------|:---------|:------------|
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get book by ID |
| GET | `/api/books/search?title={title}` | Search books by title |
| POST | `/api/books` | Add a new book |
| DELETE | `/api/books/{id}` | Delete a book |

#### 📸 Postman Screenshots – Question 1

> **GET All Books**
>
> ![Get All Books](screenshots/q1_get_all_books.png)
<img width="923" height="737" alt="Image" src="https://github.com/user-attachments/assets/a685ec67-e26a-4ed4-99c8-2a107f9159e2" />

> **GET Book by ID**
>
> <img width="930" height="706" alt="Image" src="https://github.com/user-attachments/assets/9f9d3ced-39bb-4ad9-adf5-b1e199b2c61c" />

> **Search Books by Title**
>
> <img width="923" height="703" alt="Image" src="https://github.com/user-attachments/assets/7cca4de9-15c7-467a-ae81-e7d271aaccbc" />

> **POST Add New Book**
>
<img width="921" height="722" alt="Image" src="https://github.com/user-attachments/assets/ba6b7cd5-b57a-4c8f-bc03-57b855131a94" />


> **DELETE Book**
>
> <img width="930" height="706" alt="Image" src="https://github.com/user-attachments/assets/9f9d3ced-39bb-4ad9-adf5-b1e199b2c61c" />

Question 2 – Student Registration API

**Base URL:** `http://localhost:8080/api/students`

#### 📸 Postman Screenshots – Question 2

> **GET All Students**
>
#### 📸 Postman Screenshots – Question 2

> **GET All Students**
><img width="946" height="637" alt="Image" src="https://github.com/user-attachments/assets/b31442a4-15d9-4c7a-8c84-3a707729bf20" />

#### 📸 Postman Screenshots – Question 2

> **GET All Students**
>
> ![Get All Students](screenshots/q2_get_all_students.png)

> **GET Student by ID**
>
> <img width="928" height="622" alt="Image" src="https://github.com/user-attachments/assets/da96797f-5fd8-4f53-8c26-266bef88dd67" />

> **GET Students by Major**
>
> ![Get Students by Major](screenshots/q2_get_by_major.png)

> **Filter Students by GPA**
>
> <img width="920" height="645" alt="Image" src="https://github.com/user-attachments/assets/f53e016e-4f06-46bb-8a98-413dd4b74610" />
> **POST Register Student**
>
> ![Register Student](screenshots/q2_post_student.png)

> **PUT Update Student**
>
> <img width="925" height="641" alt="Image" src="https://github.com/user-attachments/assets/3e4211bd-dc34-4c2a-a6fc-67fab388f554" />


> **GET Student by ID**
>
> <img width="928" height="622" alt="Image" src="https://github.com/user-attachments/assets/2d0e0c9a-a79d-4330-9bcc-0de7993f1930" />

> **GET Students by Major**
>
> ![Get Students by Major](screenshots/q2_get_by_major.png)

> **Filter Students by GPA**
>
> <img width="920" height="645" alt="Image" src="https://github.com/user-attachments/assets/bf161a3c-b533-4e53-8415-140be226258e" />

> **POST Register Student**
>
> <img width="920" height="633" alt="Image" src="https://github.com/user-attachments/assets/aa59bbdd-5e28-4f80-b11f-08917d614fbf" />

> **PUT Update Student**
><img width="925" height="641" alt="Image" src="https://github.com/user-attachments/assets/5c642bb7-12cb-42fa-9305-1e7039de4478" />
> 

### Question 3 – Restaurant Menu API

**Base URL:** `http://localhost:8080/api/menu`
Postman Screenshots – Question 3

> **GET All Menu Items**
>
> <img width="925" height="649" alt="Image" src="https://github.com/user-attachments/assets/e1b9c0be-23d4-429a-8195-466ff8a74bc2" />


> **GET Menu Item by ID**
><img width="927" height="709" alt="Image" src="https://github.com/user-attachments/assets/65f114c4-fe75-44e0-a6f0-5c1b2532d116" />

### Question 4 – E-commerce Product API

**Base URL:** `http://localhost:8082/api/products`

#### 📸 Postman Screenshots – Question 4

> **GET All Products**
>
> <img width="917" height="646" alt="Image" src="https://github.com/user-attachments/assets/63308888-6395-4fd4-8d80-9fea45e87ebb" />

> **GET Product by ID**
>
<img width="924" height="645" alt="Image" src="https://github.com/user-attachments/assets/6b0e7482-7ead-4b43-8622-7951fb0da4ea" />

> **GET Products by Category**
>
<img width="920" height="650" alt="Image" src="https://github.com/user-attachments/assets/e20674e4-8cc3-40d6-8bb3-363b66f96188" />

> **GET Products by Brand**
>
<img width="922" height="652" alt="Image" src="https://github.com/user-attachments/assets/88605f2a-e7e6-412d-9349-a1852ab34182" />

> **Search Products**
>
<img width="923" height="635" alt="Image" src="https://github.com/user-attachments/assets/344a8d1b-14a1-4765-8b67-d97b21a2b93b" />

> **GET Products by Price Range**
>
<img width="924" height="637" alt="Image" src="https://github.com/user-attachments/assets/63c63c3d-685d-4fbe-833b-cfc79c3e103d" />

> **GET In-Stock Products**
>
<img width="924" height="646" alt="Image" src="https://github.com/user-attachments/assets/53d87e02-c627-4485-8c59-a4558f8575c5" />

> **POST Add Product**
>
<img width="926" height="654" alt="Image" src="https://github.com/user-attachments/assets/5b7bc6fc-213a-4384-a6c9-f908857bb0d5" />

> **PUT Update Product**
><img width="922" height="655" alt="Image" src="https://github.com/user-attachments/assets/b30f3131-ea66-4ed0-b5fa-aaaa3e4c2893" />

> **PATCH Update Stock**
>
<img width="922" height="655" alt="Image" src="https://github.com/user-attachments/assets/d23dca8d-1ffd-43c8-8fa6-4c8c2dcee0a8" />

> **DELETE Product**
>
<img width="928" height="660" alt="Image" src="https://github.com/user-attachments/assets/33b796b2-c5e7-4bca-b2ba-f65fe3392247" />
Task Management API

**Base URL:** `http://localhost:8080/api/tasks
Postman Screenshots – Question 5

> **GET All Tasks**
>
<img width="922" height="651" alt="Image" src="https://github.com/user-attachments/assets/5b476b45-c39b-4e27-bba6-c9f37d0d9495" />

> **GET Task by ID**
>
<img width="925" height="638" alt="Image" src="https://github.com/user-attachments/assets/a1405840-63a9-4bc0-b447-8427239ff2d0" />

> **GET Tasks by Status**
>
<img width="924" height="647" alt="Image" src="https://github.com/user-attachments/assets/cfa756a8-5cdf-4285-a020-9ae3d8bd92c3" />

> **GET Tasks by Priority**
>
<img width="921" height="641" alt="Image" src="https://github.com/user-attachments/assets/144b9edf-9cb1-4e4d-b7db-e90bc5bc9558" />

> **POST Create Task**
>
<img width="936" height="642" alt="Image" src="https://github.com/user-attachments/assets/be552de4-7478-466b-94be-ac59bad01be8" />

> **PUT Update Task**
>
<img width="1366" height="261" alt="Image" src="https://github.com/user-attachments/assets/99b778df-ce30-41f6-b72c-69c8f80f3712" />
> **PATCH Mark Completed**
>
<img width="926" height="644" alt="Image" src="https://github.com/user-attachments/assets/efe66d23-fbdb-4a85-8675-f5e49ed90df6" />

> **DELETE Task**
>
<img width="921" height="648" alt="Image" src="https://github.com/user-attachments/assets/25e2d9fc-570f-463e-9337-24219bae118d" />
### Bonus – User Profile API

**Base URL:** `http://localhost:8080/api/users`
#### 📸 Postman Screenshots – Bonus

> **GET All Users**
>
<img width="927" height="646" alt="Image" src="https://github.com/user-attachments/assets/c325270e-b156-4059-8b1c-7d67defd381a" />

> **GET User by ID**
><img width="920" height="655" alt="Image" src="https://github.com/user-attachments/assets/29b4111b-bd1b-4f54-92de-1e7dcbd4d681" />

> **Search Users by Username**
>
> ![Search Users](screenshots/bonus_search_users.png)

> **GET Users by Country**
>
> ![Get by Country](screenshots/bonus_get_by_country.png)

> **POST Create User**
>
> ![Create User](screenshots/bonus_post_user.png)

> **DELETE User**
>
> ![Delete User](screenshots/bonus_delete_user.png)

