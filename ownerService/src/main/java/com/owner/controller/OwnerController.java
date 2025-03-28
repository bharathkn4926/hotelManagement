package com.owner.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.owner.client.GuestDetailsClient;
import com.owner.client.RoomDetailsClient;
import com.owner.client.StaffDetailsClient;
import com.owner.model.GuestDetails;
import com.owner.model.RoomDetails;
import com.owner.model.StaffDetails;

@RestController
@RequestMapping("/owner")
@EnableFeignClients(basePackages = "com.*")

public class OwnerController {
	
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
	@DeleteMapping("/deleteguest/{guestId}") 
	public ResponseEntity<String> deleteGuestDetails(@PathVariable int guestId){
		return guestClient.deleteGuestDetails(guestId);
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
	
	@PostMapping("/addNewRoomDetails")
	public ResponseEntity<RoomDetails> addRoomDetails(@RequestBody RoomDetails newroom){
		return roomClient.addRoomDetails(newroom);
	}
	
	@DeleteMapping("/deleteRoomDetails/{roomId}")
	public ResponseEntity<String> deleteRoomDetails(@PathVariable int roomId){
		return roomClient.deleteRoomDetails(roomId);
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
	
	@PostMapping("/addnewstaffdetails")
	public ResponseEntity<StaffDetails> addNewStaffDetails(@RequestBody StaffDetails newStaff){
		return staffClient.addNewStaffDetails(newStaff);
	}
	
	@DeleteMapping("/deletestaffdetails/{staffId}")
	public ResponseEntity<String> deleteStaffDetails( @PathVariable int staffId){
		return staffClient.deleteStaffDetails(staffId);
	}
	
	@GetMapping("/getstaffdetailsbyid/{staffId}")
	public ResponseEntity<StaffDetails> getStaffDetailsById(@PathVariable int staffId){
		return staffClient.getStaffDetailsById(staffId);
	}
	
	@PutMapping("/updatedetailsbyid/{staffId}")
	public ResponseEntity<StaffDetails> updateStaffDetails(@PathVariable int staffId,@RequestBody StaffDetails staff){
		return staffClient.updateStaffDetails(staffId, staff);
	}

}
