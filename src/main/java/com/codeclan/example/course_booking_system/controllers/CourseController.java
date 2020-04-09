package com.codeclan.example.course_booking_system.controllers;


import com.codeclan.example.course_booking_system.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity getAllCoursesAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "location") String location,
            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "customer_id") Long customer_id)
    {
        if (name != null){
            return new ResponseEntity(courseRepository.findByName(name), HttpStatus.OK);
        }
        if (location != null){
            return new ResponseEntity(courseRepository.findByLocation(location), HttpStatus.OK);
        }
        if (rating != null){
            return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (customer_id != null){
            return new ResponseEntity(courseRepository.findAllByBookingsCustomerId(customer_id), HttpStatus.OK);
        }


        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);

    }

}
