package com.staffdetails.controller;

import java.util.List;
import java.util.Optional;

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


import com.staffdetails.model.StaffDetails;
import com.staffdetails.repository.StaffDetailRepository;
import com.staffdetails.service.StaffDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/staffdetails")
public class StaffDetailsController {
	
	@Autowired
	StaffDetailRepository staffrepo;
	
	@Autowired
	StaffDetailsService staffservice;
	
	private static final Logger logger = LoggerFactory.getLogger(StaffDetails.class);
	
	@GetMapping("/getallstaffdetails")
	public ResponseEntity<List<StaffDetails>>  getAllStaffDetails(){
		logger.info("Inside getAllStaffDetails() method of StaffDetailsController");
		List<StaffDetails> stafflist=staffservice.getAllStaffDetails();
		return new ResponseEntity<List<StaffDetails>>(stafflist,HttpStatus.OK);	
	}
	
	
	@PostMapping("/addnewstaffdetails")
	public ResponseEntity<StaffDetails> addNewStaffDetails(@RequestBody StaffDetails newStaff){
		logger.info("Inside addNewStaffDetails() method of StaffDetailsController");
		StaffDetails staff=staffservice.addNewStaffDetails(newStaff);
		return new ResponseEntity<StaffDetails>(staff,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletestaffdetails/{staffId}")
	public ResponseEntity<String> deleteStaffDetails( @PathVariable int staffId){
		logger.info("Inside addNewStaffDetails() method of StaffDetailsController");
		staffservice.deleteStaffDetails(staffId);
		return new ResponseEntity<String>("Staff details deleted sucessfully",HttpStatus.OK);
	}
	
	@GetMapping("/getstaffdetailsbyid/{staffId}")
	public ResponseEntity<StaffDetails> getStaffDetailsById(@PathVariable int staffId){
		logger.info("Inside getStaffDetails() method of StaffDetailsController");
		Optional<StaffDetails> staff=staffservice.getStaffDetailsById(staffId);
		return new ResponseEntity<StaffDetails>(staff.get(),HttpStatus.OK);
	}
	
	@PutMapping("/updatedetails")
	public ResponseEntity<StaffDetails> updateStaffDetails(@RequestBody StaffDetails staff){
		logger.info("Inside updateStaffDetails() method of StaffDetailsController");
		Optional<StaffDetails> _staff=staffservice.getStaffDetailsById(staff.getStaffId());
		return new ResponseEntity<StaffDetails>(staffservice.updateStaffDetails( staff),HttpStatus.OK);
		
	}

}
