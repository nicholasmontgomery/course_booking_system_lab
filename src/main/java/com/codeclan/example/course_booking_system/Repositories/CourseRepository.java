package com.codeclan.example.course_booking_system.Repositories;

import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

    List<Course> findByName(String name);
    List<Course> findByLocation(String location);
    List<Course> findByRating(int rating);
    List<Course> findAllByBookingsCustomerId(Long customerId);
}
