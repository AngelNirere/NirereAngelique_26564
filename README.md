# Servlet Assignment - Login and Redirect

This project demonstrates two servlet assignments: a login system with password validation and a redirect functionality to Google search.

## Assignment 1: Login Servlet

### Features
- Username and password input form
- Password strength validation (minimum 8 characters)
- Dynamic response based on password length

### Screenshots

#### Login Form
![image alt](https://github.com/AngelNirere/NirereAngelique_26564/blob/fa102ec64a94d26ce2013e3bc6ce87025be8873b/screenshot1.png.PNG)
*The main login page at `http://localhost:8080/login_page/` with username and password fields*

#### Weak Password Response
![image alt](https://github.com/AngelNirere/NirereAngelique_26564/blob/edd40edcb420144955205c7ce572fb8ea2f831dd/screenshot2.png.PNG)
*When password is less than 8 characters, displays: "Hello [username], your password is weak. Try a strong one."*

#### Strong Password Response
![image alt](https://github.com/AngelNirere/NirereAngelique_26564/blob/24a6e4f617c757d219100ec3697877d2f3df51ac/screenshot3.png.PNG)
*When password is 8+ characters, displays: "Welcome [username]"*

## Assignment 2: Send Redirect

### Features
- Input field for search query
- Fetch button to trigger redirect
- Automatic redirect to Google search using `sendRedirect()`

### Screenshots

#### Redirect Form
![image alt](https://github.com/AngelNirere/NirereAngelique_26564/blob/81f2ca7612eda0d2f4b05fbf1503471744691bb4/screenshot3.png.PNG)
*The redirect page at `http://localhost:8080/login_page/redirect.html` with search input and Fetch button*

#### Google Redirect Result
![image alt](https://github.com/AngelNirere/NirereAngelique_26564/blob/552c698f28aaf157781381e98942e3a5d119d1f3/screenshot5.png.PNG)
*After clicking Fetch, user is redirected to Google search results for the entered query*

## How It Works

1. **Login Flow**: Form → LoginServlet → Password validation → Response
2. **Redirect Flow**: Form → RedirectServlet → `sendRedirect()` → Google search

## Technology Stack
- Java Servlets
- Apache Tomcat 8.5
- HTML forms
- Maven build system

## Running the Application
1. Deploy to Tomcat webapps directory
2. Access `http://localhost:8080/login_page/` for login
3. Access `http://localhost:8080/login_page/redirect.html` for redirect functionality
