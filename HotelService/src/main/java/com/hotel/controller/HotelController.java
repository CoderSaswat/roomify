package com.hotel.controller;

import com.hotel.client.RoomClient;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomClient roomClient;

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        hotel.setSearchKey(hotel.getName() + ", " + hotel.getAddress());
        return hotelRepository.save(hotel);
    }

    @GetMapping
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping(path = "/{hotelId}")
    public Hotel getHotelById(@PathVariable long hotelId) {
        return hotelRepository.findById(hotelId).get();
    }

    @GetMapping(path = "/search/{key}")
    public List<Hotel> searchByName(@PathVariable String key) {
        return hotelRepository.findBySearchKeyContainingIgnoreCase(key);
    }

    @GetMapping(path = "/{hotelId}/rooms")
    public List<Room> getRoomsByHotelId(@PathVariable long hotelId) {
        return roomClient.getRoomsByHotelId(hotelId);
    }
}