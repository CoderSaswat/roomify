package com.booking.controller;

import com.booking.client.RoomClient;
import com.booking.enitity.Booking;
import com.booking.enitity.Room;
import com.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomClient roomClient;

    @GetMapping
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        Room room = roomClient.getRoomById(booking.getRoomId());
        if (room != null && room.getAvailable()) {
            booking.setStatus("CONFIRMED");
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Room not available");
    }
    @GetMapping(path = "/customer-bookings/{customerId}")
    public List<Booking> getCustomerBookings(@PathVariable Long customerId){
       return bookingRepository.findByCustomerId(customerId);
    }

    @GetMapping(path = "/hotel-bookings/{hotelId}")
    public List<Booking> getHotelBookings(@PathVariable Long hotelId){
        return bookingRepository.findByHotelId(hotelId);
    }
}
