package com.staffdetails.service;

import java.util.List;
import java.util.Optional;

import com.staffdetails.model.StaffDetails;


public interface StaffDetailsService {

	public List<StaffDetails> getAllStaffDetails();
	public StaffDetails addNewStaffDetails(StaffDetails newStaff);
	public String deleteStaffDetails(int staffId);
	public StaffDetails updateStaffDetails(StaffDetails staff);
	public Optional<StaffDetails> getStaffDetailsById(int staffId);
}
