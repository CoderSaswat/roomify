package com.customer.client;

import com.customer.entity.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8081",value = "BookingServiceClient")
@FeignClient(name = "BOOKING-SERVICE")
public interface BookingClient {
    @GetMapping("/bookings/customer-bookings/{customerId}")
    List<Booking> getCustomerBookingsByCustomerId(@PathVariable("customerId") Long customerId);
}
