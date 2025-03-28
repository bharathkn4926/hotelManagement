package com.guestdetails.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guestdetails.model.GuestDetails;
import com.guestdetails.repository.GuestDetailsRepository;
import com.guestdetails.service.GuestDetailsService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/guestdetails")
public class GuestDetailsController {
	
	
	@Autowired
	GuestDetailsService guestService;
	
	@Autowired
	GuestDetailsRepository guestrepo;
	
	private static final Logger logger = LoggerFactory.getLogger(GuestDetails.class);
	
	@GetMapping("/getallguests")
	public ResponseEntity<List<GuestDetails>> getAllGuestDetails(){
		logger.info("Inside getAllGuestDetails() method of GuestDetailsController");
		List<GuestDetails> list= guestService.getAllGuestDetails();	
		return new ResponseEntity<List<GuestDetails>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/addnewguest")
	
	public ResponseEntity<GuestDetails> addGuestDetails(@RequestBody @Valid GuestDetails newguest) {
		logger.info("Inside addGuestDetails() method of GuestDetailsController");
		  GuestDetails guest= guestService.addGuestDetails(newguest);
		return new ResponseEntity<GuestDetails> (guest,HttpStatus.CREATED);
	}
	
	
	  @DeleteMapping("/deleteguest/{guestId}") 
	  public ResponseEntity<String> deleteGuestDetails(@PathVariable int guestId) {
	  logger.info("Inside deleteGuestDetails() method of GuestDetailsController");
	  guestService.deleteGuestDetails(guestId); return new
	  ResponseEntity<String>("Deleted Sucessfully",HttpStatus.ACCEPTED);
	  
	  }
	
	
	
	@GetMapping("/getguestdeatilsbyid/{guestId}")
	public ResponseEntity<GuestDetails> getGuestDetailsById(@PathVariable int guestId){
		logger.info("Inside getGuestDetailsById() method of GuestDetailsController");
		Optional<GuestDetails> guest= guestService.getGuestDetailsById(guestId);
		return new ResponseEntity<GuestDetails>(guest.get(),HttpStatus.OK);
	}
	
	@PutMapping("/updateguestdetails")
	public ResponseEntity<GuestDetails> updateGuestDetails(  @RequestBody GuestDetails guest) {
		logger.info("Inside updateGuestDetails() method of GuestDetailsController");
		Optional<GuestDetails> _guest= guestService.getGuestDetailsById(guest.getGuestId());
		return new ResponseEntity<GuestDetails>(guestService.updateGuestDetails( guest),HttpStatus.CREATED);
	}
	
	
}
