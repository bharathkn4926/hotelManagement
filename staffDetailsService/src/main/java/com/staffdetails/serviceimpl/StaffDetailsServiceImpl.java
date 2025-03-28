package com.staffdetails.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.staffdetails.customeException.EmptyInputException;
import com.staffdetails.customeException.EmptyListException;
import com.staffdetails.model.StaffDetails;
import com.staffdetails.repository.StaffDetailRepository;
import com.staffdetails.service.StaffDetailsService;

@Service
public class StaffDetailsServiceImpl implements StaffDetailsService {
	
	@Autowired
	StaffDetailRepository staffRepo;
	

	@Autowired
	SequenceGeneratorService seqService;


	@Override
	public List<StaffDetails> getAllStaffDetails() {
		System.out.println("Inside getAllStaffDetails() method of StaffDetailsController");
		List<StaffDetails> stafflist=staffRepo.findAll();
		if(stafflist.isEmpty()) throw new EmptyListException();
		return stafflist;
	}

	@Override
	public StaffDetails addNewStaffDetails(StaffDetails newStaff) {
		
		if(newStaff.getStaffName().isEmpty()||newStaff.getStaffAddress().isEmpty()
				||newStaff.getStaffDesiqnation().isEmpty()||newStaff.getStaffEmailId().isEmpty()
				||newStaff.getStaffPhoneNumber().isEmpty()||newStaff.getStaffSalary()<=0) throw new EmptyInputException();
		System.out.println("Inside addNewStaffDetails() method of StaffDetailsController");
		newStaff.setStaffId(seqService.getSequenceNumber(StaffDetails.SEQUENCE_NAME));
		return staffRepo.save(newStaff);
	}

	@Override
	public String deleteStaffDetails(int staffId) throws MethodArgumentTypeMismatchException  {
		
		if(staffId<=0) throw new IllegalStateException();
		
		if(staffRepo.findById(staffId).get()==null) throw new NoSuchElementException();

		System.out.println("Inside deleteStaffDetails() method of StaffDetailsController");
		staffRepo.deleteById(staffId);
		return "Staff details deleted sucessfully";
	}

	@Override
	public StaffDetails updateStaffDetails( StaffDetails staff) throws IllegalStateException,NoSuchElementException {
		System.out.println("Inside updateStaffDetails() method of StaffDetailsController");
		
		Optional<StaffDetails> staffdata=staffRepo.findById(staff.getStaffId());
		
		StaffDetails _staff=staffdata.get();
		
		_staff.setStaffName(staff.getStaffName());
		_staff.setStaffPhoneNumber(staff.getStaffPhoneNumber());
		_staff.setStaffEmailId(staff.getStaffEmailId());
		_staff.setStaffAddress(staff.getStaffAddress());
		_staff.setStaffDesiqnation(staff.getStaffDesiqnation());
		_staff.setStaffSalary(staff.getStaffSalary());
		_staff.setStaffDateOfJoining(staff.getStaffDateOfJoining());
		
		if(_staff.getStaffName().isEmpty()||_staff.getStaffAddress().isEmpty()
				||_staff.getStaffDesiqnation().isEmpty()||_staff.getStaffEmailId().isEmpty()
				||_staff.getStaffPhoneNumber().isEmpty()||_staff.getStaffSalary()<=0) throw new EmptyInputException();
		
		return staffRepo.save(_staff);
	}

	@Override
	public Optional<StaffDetails> getStaffDetailsById(int staffId) throws IllegalStateException,NoSuchElementException,MethodArgumentTypeMismatchException{
		System.out.println("Inside getStaffDetailsById() method of StaffDetailsController");
		return staffRepo.findById(staffId);
	}

}
