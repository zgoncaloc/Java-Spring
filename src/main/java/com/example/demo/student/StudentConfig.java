package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    /**
     * Creates a `CommandLineRunner` bean for populating the student repository with some initial data.
     *
     * This method leverages Spring's `@Configuration` annotation to mark this class as a configuration bean.
     * It defines a bean of type `CommandLineRunner` using the `@Bean` annotation. The bean takes the `StudentRepository`
     * as a dependency and is executed after application startup.
     *
     * @param repository The `StudentRepository` bean used to interact with the student data.
     * @return A `CommandLineRunner` bean that populates the repository with sample student data.
     */
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            // Create sample student objects
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jaine@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY,5)
            );
            // Save the sample students to the repository
            repository.saveAll(List.of(mariam,alex)
            );
        };
    }
}
