# Java-Spring

>Please visit Wiki for App Overview and Postman Requests.

This application is a student management system built with Spring Boot that allows users to manage student data in a  PostgreSQL database.

Functionalities:

View Students: Users can retrieve a list of all students currently stored in the database.
Add Students: Users can register new students by providing their name, email address, and date of birth.
Update Students: Users can modify existing student information like name and email address.
Delete Students: Users can remove students from the database based on their ID.

Components:

1. Student Entity (Student.java):
Defines the data model for a student with attributes like id (primary key), name, email, date of birth, and a calculated age.
Annotated with @Entity to mark it as a JPA entity mapped to a database table named "student" (by default).

2. Spring Boot Configuration (application.properties):
Contains configuration properties for the application, including:
Database connection details (URL, username, password)

4. Student Repository (StudentRepository):
Extends JpaRepository from Spring Data JPA, providing methods for CRUD (Create, Read, Update, Delete) operations on student entities in the database.

5. Student Service (StudentService):
Provides business logic for managing student data.
Interacts with the StudentRepository to perform CRUD operations.
Validates student data.

6. Student Controller (StudentController):
A Spring MVC controller class that exposes REST API endpoints for student management.
Maps HTTP requests to corresponding methods for:
Retrieving a list of all students (GET /api/v1/student)
Adding a new student (POST /api/v1/student)
Updating an existing student (PUT /api/v1/student/{studentId})
Deleting a student (DELETE /api/v1/student/{studentId})

7. CommandLineRunner (StudentConfig):
A bean configured to run after application startup.
Used for populating the database with sample student data during development/testing.

