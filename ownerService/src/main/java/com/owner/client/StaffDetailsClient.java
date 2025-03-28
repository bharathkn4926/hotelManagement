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

import com.owner.model.StaffDetails;



@FeignClient(url = "http://localhost:1003/staffdetails",name = "staffDetails-client")
public interface StaffDetailsClient {

	@GetMapping("/getallstaffdetails")
	public ResponseEntity<List<StaffDetails>>  getAllStaffDetails();
	
	@PostMapping("/addnewstaffdetails")
	public ResponseEntity<StaffDetails> addNewStaffDetails(@RequestBody StaffDetails newStaff);
	
	@DeleteMapping("/deletestaffdetails/{staffId}")
	public ResponseEntity<String> deleteStaffDetails( @PathVariable int staffId);
	
	@GetMapping("/getstaffdetailsbyid/{staffId}")
	public ResponseEntity<StaffDetails> getStaffDetailsById(@PathVariable int staffId);
	
	@PutMapping("/updatedetailsbyid/{staffId}")
	public ResponseEntity<StaffDetails> updateStaffDetails(@PathVariable int staffId,@RequestBody StaffDetails staff);
}
