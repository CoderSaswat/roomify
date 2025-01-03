package com.room.controller;

import com.room.client.HotelClient;
import com.room.entity.Hotel;
import com.room.entity.Room;
import com.room.repositoty.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelClient hotelClient;

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        Hotel hotel = hotelClient.getHotelById(room.getHotelId());
        room.setName(hotel.getName()+"_"+room.getName());
        return roomRepository.save(room);
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @GetMapping(path = "/{roomId}")
    public Room getRoomById(@PathVariable long roomId) {
        return roomRepository.findById(roomId).get();
    }
    @GetMapping(path = "/hotel/{hotelId}")
    public List<Room> getRoomsByHotelId(@PathVariable long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }

}
