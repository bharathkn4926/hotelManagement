package com.manager.controller;

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

import com.manager.clients.GuestDetailsClient;
import com.manager.clients.RoomDetailsClient;
import com.manager.clients.StaffDetailsClient;
import com.manager.model.GuestDetails;
import com.manager.model.RoomDetails;
import com.manager.model.StaffDetails;





@RestController
@RequestMapping("/manager")
@EnableFeignClients("com.*")
public class ManagerController {
	
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
		
		@GetMapping("/getstaffdetailsbyid/{staffId}")
		public ResponseEntity<StaffDetails> getStaffDetailsById(@PathVariable int staffId){
			return staffClient.getStaffDetailsById(staffId);
		}


	


}
