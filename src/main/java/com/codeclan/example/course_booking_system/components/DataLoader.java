package com.codeclan.example.course_booking_system.components;

import com.codeclan.example.course_booking_system.Repositories.BookingRepository;
import com.codeclan.example.course_booking_system.Repositories.CourseRepository;
import com.codeclan.example.course_booking_system.Repositories.CustomerRepository;
import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){
    
    }

    public void run(ApplicationArguments args) {
        Customer customer1 = new Customer("Nick", "Edinburgh", 21);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Roosa", "Edinburgh", 27);
        customerRepository.save(customer2);

        Course course1 = new Course("Software Development", "Edinburgh", 5);
        courseRepository.save(course1);


        Booking booking1 = new Booking("01/01/2020", customer1, course1);
        bookingRepository.save(booking1);

        customer1.addBooking(booking1);
        customerRepository.save(customer1);



    }

}
