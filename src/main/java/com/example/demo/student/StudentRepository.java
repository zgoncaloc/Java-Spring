package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    /**
     * Finds a student by their email address.
     *
     * This method uses a JPA query with a named parameter ":email" to search
     * for a student whose email address matches the provided value.
     *
     * @param email The email address of the student to find.
     * @return An `Optional<Student>` object containing the found student
     *         or `Optional.empty()` if no student is found.
     */
    @Query("SELECT s FROM Student s WHERE s.email  = :email")
    Optional<Student> findStudentByEmail(@Param("email") String email);

    @Query("SELECT s FROM Student s WHERE s.dob  = :dob")
    Optional<Student> findStudentByDob(@Param("dob") LocalDate dob);

}
