# E-commerce Store

This project is an e-commerce application built with Spring Boot. Customers can log in via JWT authentication, search, sort, view, and purchase products. Admins can manage the inventory. The frontend is built using HTML, CSS, and JavaScript and is located in the `static` folder.

## Features

### Customer
- JWT Authentication for secure login.
- Search and sort products.
- View detailed product information.
- Buy products.

### Admin
- Manage product inventory (add, update, delete products).

## Getting Started

### Prerequisites
- Java 17
- MySQL (or any other preferred relational database)

### Installation

1. **Clone the Repository**
    ```sh
    git clone https://github.com/theinsanewarrior/ecommerce-store.git
    cd ecommerce-store
    ```

2. **Create the Database Schema**
    - Create a local schema named `mystoredb`.
    - Update the `application.properties` file with your database username and password.
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/mystoredb
      spring.datasource.username=yourusername
      spring.datasource.password=yourpassword
      ```

3. **Build and Run the Application**
    ```sh
    ./gradlew build
    ./gradlew bootRun
    ```

4. **Access the Application**
    - Open your browser and go to `http://localhost:8080/home`.

## Project Structure

- **Backend:** Spring Boot
- **Frontend:** HTML, CSS, JavaScript (located in the `static` folder)

Happy shopping with our E-commerce Store!
