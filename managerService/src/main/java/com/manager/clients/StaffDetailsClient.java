package com.manager.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manager.model.StaffDetails;





@FeignClient(url = "http://localhost:1003/staffdetails",name = "staffDetails-client1")
public interface StaffDetailsClient {

	@GetMapping("/getallstaffdetails")
	public ResponseEntity<List<StaffDetails>>  getAllStaffDetails();
	
	@PostMapping("/addnewstaffdetails")
	public ResponseEntity<StaffDetails> addNewStaffDetails(@RequestBody StaffDetails newStaff);
	
	
	@GetMapping("/getstaffdetailsbyid/{staffId}")
	public ResponseEntity<StaffDetails> getStaffDetailsById(@PathVariable int staffId);
	
}
