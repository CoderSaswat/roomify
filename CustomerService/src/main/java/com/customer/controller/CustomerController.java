package com.customer.controller;

import com.customer.client.BookingClient;
import com.customer.entity.Booking;
import com.customer.entity.Customer;
import com.customer.entity.CustomerBooking;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingClient bookingClient;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/customer-bookings/{customerId}")
    public CustomerBooking getCustomerBookings(@PathVariable Long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        List<Booking> bookingList = bookingClient.getCustomerBookingsByCustomerId(customerId);
        return new CustomerBooking(customer,bookingList);
    }


}
