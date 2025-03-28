package com.receptionist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.receptionist.client.GuestDetailsClient;
import com.receptionist.client.RoomDetailsClient;
import com.receptionist.client.StaffDetailsClient;
import com.receptionist.model.GuestDetails;
import com.receptionist.model.RoomDetails;
import com.receptionist.model.StaffDetails;


@RestController
@RequestMapping("/receptionist")
@EnableFeignClients("com.*")
public class ReceptionistController {
	
	@Autowired
	GuestDetailsClient guestClient;
	
	@Autowired
	RoomDetailsClient roomClient;
	
	@Autowired
	StaffDetailsClient staffClient;
	
/* Guest functionalities */
	
	@GetMapping("/getallguests")
	public ResponseEntity<List<GuestDetails>> getAllGuestDetails(){
		return guestClient.getAllGuestDetails();		
	}
	@PostMapping("/addnewguest")
	public ResponseEntity<GuestDetails> addGuestDetails(@RequestBody @Valid GuestDetails newguest){
		return guestClient.addGuestDetails(newguest);
	}

	@GetMapping("/getguestdeatilsbyid/{guestId}")
	public ResponseEntity<GuestDetails> getGuestDetailsById(@PathVariable int guestId){
		return guestClient.getGuestDetailsById(guestId);
	}
	@PutMapping("/updateguestdetails/{guestId}")
	public ResponseEntity<GuestDetails> updateGuestDetails( @PathVariable int guestId, @RequestBody GuestDetails guest){
		return guestClient.updateGuestDetails(guestId, guest);
	}
	
	//Room Functionalities
	
		@GetMapping("/getAllRoomDetails")
		public ResponseEntity<List<RoomDetails>> getAllRoomDetails(){
			return roomClient.getAllRoomDetails();
		}
		
		@PutMapping("/updateRoomDetails/{roomId}")
		public ResponseEntity<RoomDetails> updateRoomDetails(@PathVariable int roomId,@RequestBody RoomDetails room){
			return roomClient.updateRoomDetails(roomId, room);
		}
		
		//Staff Functionalities
		
		@GetMapping("/getallstaffdetails")
		public ResponseEntity<List<StaffDetails>>  getAllStaffDetails(){
			return staffClient.getAllStaffDetails();
		}
		

}
