package com.owner.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.owner.model.RoomDetails;



@FeignClient(url = "http://localhost:1002/rooms",name = "roomDetails-client")
public interface RoomDetailsClient {

	@GetMapping("/getAllRoomDetails")
	public ResponseEntity<List<RoomDetails>> getAllRoomDetails();
	
	@PostMapping("/addNewRoomDetails")
	public ResponseEntity<RoomDetails> addRoomDetails(@RequestBody RoomDetails newroom);
	
	@DeleteMapping("/deleteRoomDetails/{roomId}")
	public ResponseEntity<String> deleteRoomDetails(@PathVariable int roomId);
	
	@PutMapping("/updateRoomDetails/{roomId}")
	public ResponseEntity<RoomDetails> updateRoomDetails(@PathVariable int roomId,@RequestBody RoomDetails room);
	
}
