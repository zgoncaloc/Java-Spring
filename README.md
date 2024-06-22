# Java-Spring

This application is a student management system built with Spring Boot that allows users to manage student data in a  PostgreSQL database.

Functionalities:

View Students: Users can retrieve a list of all students currently stored in the database.
Add Students: Users can register new students by providing their name, email address, and date of birth.
Update Students: Users can modify existing student information like name and email address (if unique).
Delete Students: Users can remove students from the database based on their ID.

Components:

1. Student Entity (Student.java):
Defines the data model for a student with attributes like id (primary key), name, email, date of birth, and a calculated age.
Annotated with @Entity to mark it as a JPA entity mapped to a database table named "student" (by default).

2. Spring Boot Configuration (application.properties):
Contains configuration properties for the application, including:
Database connection details (URL, username, password - remember to replace with a secure password!)
JPA settings like spring.jpa.hibernate.ddl-auto (used for development/testing to create/drop tables)
Other application-specific configurations

3. Student Repository (StudentRepository):
Extends JpaRepository from Spring Data JPA, providing methods for CRUD (Create, Read, Update, Delete) operations on student entities in the database.
Includes a custom query method findStudentByEmail to search for a student by their email address.

4. Student Service (StudentService):
Provides business logic for managing student data.
Interacts with the StudentRepository to perform CRUD operations.
Validates student data (e.g., checking for unique email addresses) before persisting changes.
Uses Spring transactions to ensure data consistency across database operations.

5. Student Controller (StudentController):
A Spring MVC controller class that exposes REST API endpoints for student management.
Maps HTTP requests to corresponding methods for:
Retrieving a list of all students (GET /api/v1/student)
Adding a new student (POST /api/v1/student)
Updating an existing student (PUT /api/v1/student/{studentId})
Deleting a student (DELETE /api/v1/student/{studentId})

6. CommandLineRunner (StudentConfig):
A bean configured to run after application startup.
Used for populating the database with sample student data during development/testing.\

Overall Structure:
src/main/java: Contains the main Java source code for the application, including the student entity, service, controller, and other relevant classes.
src/main/resources: Contains resources used by the application, such as the application.properties file.
pom.xml: The Maven project configuration file that defines project dependencies and build instructions.
