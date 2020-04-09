package com.codeclan.example.course_booking_system.controllers;


import com.codeclan.example.course_booking_system.Repositories.BookingRepository;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity getAllBookingsAndFilters(
            @RequestParam(required = false, name = "customer") Customer customer,
            @RequestParam(required = false, name = "course") Course course,
            @RequestParam(required = false, name = "date") String date)
    {

        if (date != null){
            return new ResponseEntity(bookingRepository.findByDate(date), HttpStatus.OK);
        }


        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);

    }

}




