package com.codeclan.example.course_booking_system.Repositories;

import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);
    List<Customer> findByTown(String town);
    List<Customer> findByAge(int age);
    List<Customer> findAllByBookingsCourseId(Long courseId);
    List<Customer> findAllByTownAndBookingsCourseId(String town, long courseId);
}

