package com.codeclan.example.course_booking_system;

import com.codeclan.example.course_booking_system.Repositories.BookingRepository;
import com.codeclan.example.course_booking_system.Repositories.CourseRepository;
import com.codeclan.example.course_booking_system.Repositories.CustomerRepository;
import com.codeclan.example.course_booking_system.models.Booking;
import com.codeclan.example.course_booking_system.models.Course;
import com.codeclan.example.course_booking_system.models.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindCustomerByName(){
		List<Customer> foundCustomers = customerRepository.findByName("Nick");
		assertEquals(1, foundCustomers.size());
	}

	@Test
	public void canFindCustomerByTown(){
		List<Customer> foundCustomers = customerRepository.findByTown("Edinburgh");
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canFindCourseByLocation(){
		List<Course> foundCourses = courseRepository.findByLocation("Edinburgh");
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> foundBookings = bookingRepository.findByDate("01/01/2020");
	}

	@Test
	public void canFindCourseByRating(){
		List<Course> foundCourses = courseRepository.findByRating(5);
	}

	@Test
	public void canFindCustomersInTown(){
		List<Customer> foundCustomers = customerRepository.findAllByTownAndBookingsCourseId("Edinburgh", 1L);
	}

	@Test
	public void canGetCustomersForCourse(){
		List<Customer> foundCustomers = customerRepository.findAllByBookingsCourseId(1L);
	}

	@Test
	public void canGetCoursesForCustomer(){
		List<Course> foundCourses = courseRepository.findAllByBookingsCustomerId(1L);
	}

}
