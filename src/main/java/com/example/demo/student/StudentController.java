package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Retrieves a list of all students.
     *
     * This method acts as a REST API endpoint exposed at the path "/api/v1/student".
     * When a GET request is made to this endpoint, it delegates the logic of retrieving
     * all students to the `studentService` and returns the list of students as a JSON response.
     *
     * @return A list of `Student` objects in JSON format.
     */
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    /**
     * Registers a new student.
     *
     * This method acts as a REST API endpoint exposed at the path "/api/v1/student".
     * When a POST request is made to this endpoint with a JSON representation of a new student
     * in the request body, it delegates the logic of adding the student to the database
     * to the `studentService`.
     *
     * @param student The new student object to be added (received in the request body).
     * @throws IllegalStateException if a student with the same email address already exists.
     */
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    /**
     * Deletes a student based on their ID.
     *
     * This method acts as a REST API endpoint exposed at the path "/api/v1/student/{studentId}".
     * When a DELETE request is made to this endpoint with a student ID path variable, it delegates
     * the logic of deleting the student to the `studentService`.
     *
     * @param studentId The ID of the student to be deleted (provided in the path variable).
     * @throws IllegalStateException if a student with the provided ID does not exist.
     */
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    /**
     * Updates an existing student's information.
     *
     * This method acts as a REST API endpoint exposed at the path "/api/v1/student/{studentId}".
     * When a PUT request is made to this endpoint with student ID and optional name/email
     * parameters, it delegates the logic of updating the student's information to the
     * `studentService`.
     *
     * @param studentId The ID of the student to be updated (provided in the path variable).
     * @param name The new name for the student (optional, received in a request parameter).
     * @param email The new email address for the student (optional, received in a request parameter).
     * @throws IllegalStateException if a student with the provided ID does not exist or
     *                              if the new email address is already taken by another student.
     */
    @PutMapping(path = "{studentId}")
    public void updateStuden(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
                studentService.updateStudent(studentId, name, email);
    }



}

