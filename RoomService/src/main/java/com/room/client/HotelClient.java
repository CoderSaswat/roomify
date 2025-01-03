package com.room.client;

import com.room.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(url = "http://localhost:8080",value = "HotelServiceClient")
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelClient {
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotelById(@PathVariable("hotelId") Long hotelId);
}
