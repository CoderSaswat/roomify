package com.room.controller;

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

    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @GetMapping(path = "/{roomId}")
    public Room getRoomById(@PathVariable long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()){
            return room.get();
        }else{
            throw new RuntimeException("room not found");
        }
    }
}
