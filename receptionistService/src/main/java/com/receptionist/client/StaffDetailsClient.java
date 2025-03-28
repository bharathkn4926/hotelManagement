package com.receptionist.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.receptionist.model.StaffDetails;

@FeignClient(url = "http://localhost:1003/staffdetails",name = "staffDetails-client2")
public interface StaffDetailsClient {

	@GetMapping("/getallstaffdetails")
	public ResponseEntity<List<StaffDetails>>  getAllStaffDetails();
	
}
