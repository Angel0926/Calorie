# Calories Tracker

This project is designed to track the calories consumed and help with meal planning. It includes a web application built with Spring Boot and JPA to work with a database.

## Requirements

Before running the application, make sure you have the following installed:

- [Java 11 or higher]
- [Maven]
- [PostgreSQL] 

## Setting up the project

1. **Clone the repository:**

   Run the following commands in your terminal:

   ```bash
   git clone https://github.com/your-username/calories-tracker.git
   cd calories-tracker
Configure the database connection:

## In the file src/main/resources/application.properties, configure the database connection settings for PostgreSQL (or another database you are using).

Example for PostgreSQL:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driverClassName=org.postgresql.Driver
Replace your_database_name, your_username, and your_password with your actual values.
    
      ```bash 
docker-compose up --build

## Install dependencies:

Run the following command to install all dependencies using Maven:

    ```bash

mvn install
Run the application:

## To run the application, use the command:

    ```bash

mvn spring-boot:run
The application will be available at http://localhost:8080.

## Test the application:

You can use Postman or any other HTTP client to send requests and test the API.

## Example requests:

Get a list of all meals:

URL: GET http://localhost:8080/meals

## Request body:

json

{
"name": "Breakfast",
"calories": 350,
"userId": 1
}

## Project Structure
src/main/java/org/example/controller: Controllers to handle requests.

src/main/java/org/example/models: Data models that are mapped to database tables.

src/main/java/org/example/repository: Repositories for database interactions.

src/main/resources: Configuration files and resources.

## Testing
To run tests, use the following command:

    ```bash   
mvn test

