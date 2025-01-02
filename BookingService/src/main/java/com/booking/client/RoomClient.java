package com.booking.client;

import com.booking.enitity.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080",value = "RoomServiceClient")
@FeignClient(name = "ROOM-SERVICE")
public interface RoomClient {
    @GetMapping("/rooms/{id}")
    Room getRoomById(@PathVariable("id") Long id);
}
