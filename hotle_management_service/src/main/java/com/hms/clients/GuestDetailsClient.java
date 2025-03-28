package com.hms.clients;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hms.model.GuestDetails;



@FeignClient(url = "http://localhost:1001/guestdetails",name = "guestDetails-client1")
public interface GuestDetailsClient {
	

	@GetMapping("/getallguests")
	public ResponseEntity<List<GuestDetails>> getAllGuestDetails();
	
	@PostMapping("/addnewguest")
	public ResponseEntity<GuestDetails> addGuestDetails(@RequestBody @Valid GuestDetails newguest);
	
	@DeleteMapping("/deleteguest/{guestId}")
	public ResponseEntity<String> deleteGuestDetails(@PathVariable int guestId);
	
	@GetMapping("/getguestdeatilsbyid/{guestId}")
	public ResponseEntity<GuestDetails> getGuestDetailsById(@PathVariable int guestId);
	
	@PutMapping("/updateguestdetails")
	public ResponseEntity<GuestDetails> updateGuestDetails(  @RequestBody GuestDetails guest);

}
