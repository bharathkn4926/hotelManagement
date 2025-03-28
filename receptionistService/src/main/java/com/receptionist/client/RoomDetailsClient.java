package com.receptionist.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.receptionist.model.RoomDetails;





@FeignClient(url = "http://localhost:1002/rooms",name = "roomDetails-client2")
public interface RoomDetailsClient {

	@GetMapping("/getAllRoomDetails")
	public ResponseEntity<List<RoomDetails>> getAllRoomDetails();
	
	@PutMapping("/updateRoomDetails/{roomId}")
	public ResponseEntity<RoomDetails> updateRoomDetails(@PathVariable int roomId,@RequestBody RoomDetails room);
	
}
