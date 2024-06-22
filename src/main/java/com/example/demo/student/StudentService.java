package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Retrieves a list of all students from the student repository.
     *
     * @return A list of all `Student` objects.
     */
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    /**
     * Adds a new student to the database.
     *
     * @param student The `Student` object to be added.
     * @throws IllegalStateException if a student with the same email already exists.
     */
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    /**
     * Deletes a student from the database based on their ID.
     *
     * @param studentId The ID of the student to be deleted.
     * @throws IllegalStateException if a student with the provided ID does not exist.
     */
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
                throw new IllegalStateException("student" +
                        " with id " + studentId + " does not exists");
            }
        studentRepository.deleteById(studentId);
    }

    /**
     * Updates an existing student's information.
     *
     * @param studentId The ID of the student to be updated.
     * @param name The new name for the student (optional).
     * @param email The new email address for the student (optional).
     * @throws IllegalStateException if a student with the provided ID does not exist or
     *                              if the new email address is already taken by another student.
     */
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isEmpty()) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        Student student = studentOptional.get(); // Safe to call get() as we checked for presence

        // Update name if provided and different from existing name
        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        // Update email if provided, different from existing email, and unique
        if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> ExistingstudentOptional = studentRepository.findStudentByEmail(email);
            if (ExistingstudentOptional.isPresent()){
                throw new IllegalStateException("email is taken");
            }
            student.setEmail(email);
        }

    }




}
