package com.example.demo.student;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a student entity in the database.
 *
 * This class is annotated with `@Entity` to indicate that it corresponds to a database table.
 * The `@Table` annotaton (optional here) can be used to specify a custom table
 */
@Entity
@Table // Can be used to specify a custom table name
public class Student {

    /**
     * The unique identifier (primary key) for the student.
     *
     * This field is annotated with `@Id` to mark it as the primary key of the student entity.
     * Additionally, the following annotations are used for sequence-based ID generation:
     *
     * - `@SequenceGenerator`: This annotation defines a sequence generator named "student_sequence"
     *   that will be used to generate unique IDs for students.
     *     - `name`: The name of the sequence generator ("student_sequence").
     *     - `sequenceName`: The actual name of the sequence table in the database ("student_sequence").
     *     - `allocationSize`: The number of IDs to allocate from the sequence at a time (1 in this case).
     *
     * - `@GeneratedValue`: This annotation instructs JPA to use the defined sequence generator ("student_sequence")
     *   with the sequence strategy (`GenerationType.SEQUENCE`) to generate the ID values for student objects.
     */
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
     /*
      * This field is marked as `@Transient` to indicate that it's not persisted to the database.
      * The `getAge` method calculates the age based on the `dob`.
      */
    @Transient
    private Integer age;


    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // (Assumes ID will be generated by the database sequence).
    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob){this.dob = dob;}
}
