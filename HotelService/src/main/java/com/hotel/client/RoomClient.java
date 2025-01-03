package com.hotel.client;

import com.hotel.entity.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8080",value = "RoomServiceClient")
@FeignClient(name = "ROOM-SERVICE")
public interface RoomClient {
    @GetMapping("rooms/hotel/{hotelId}")
    List<Room> getRoomsByHotelId(@PathVariable("hotelId") Long hotelId);
}
