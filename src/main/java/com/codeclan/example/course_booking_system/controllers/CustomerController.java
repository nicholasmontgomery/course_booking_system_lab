package com.codeclan.example.course_booking_system.controllers;

import com.codeclan.example.course_booking_system.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "course_id") Long course_id)
    {
        if (name != null){
            return new ResponseEntity(customerRepository.findByName(name), HttpStatus.OK);
        }
        if (town != null){
            return new ResponseEntity(customerRepository.findByTown(town), HttpStatus.OK);
        }
        if (age != null){
            return new ResponseEntity(customerRepository.findByAge(age), HttpStatus.OK);
        }
        if (course_id != null){
            return new ResponseEntity(customerRepository.findAllByBookingsCourseId(course_id), HttpStatus.OK);
        }

        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);

    }

}