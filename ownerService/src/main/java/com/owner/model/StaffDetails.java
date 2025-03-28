package com.owner.model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StaffDetails {
	
	
	public int staffId;	
	public String staffName;	
	public String staffPhoneNumber;	
	public String staffEmailId;	
	public String staffAddress;
	public String staffDesiqnation;
	public double staffSalary;
	@JsonFormat(pattern="dd/MM/yy")
	public Date staffDateOfJoining;
	

	public StaffDetails() {
		super();
	}
	
	public StaffDetails(int staffId, String staffName, String staffPhoneNumber, String staffEmailId, String staffAddress,
			String staffDesiqnation, double staffSalary, Date staffDateOfJoining) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPhoneNumber = staffPhoneNumber;
		this.staffEmailId = staffEmailId;
		this.staffAddress = staffAddress;
		this.staffDesiqnation = staffDesiqnation;
		this.staffSalary = staffSalary;
		this.staffDateOfJoining=staffDateOfJoining;
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}
	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}
	public String getStaffEmailId() {
		return staffEmailId;
	}
	public void setStaffEmailId(String staffEmailId) {
		this.staffEmailId = staffEmailId;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public String getStaffDesiqnation() {
		return staffDesiqnation;
	}
	public void setStaffDesiqnation(String staffDesiqnation) {
		this.staffDesiqnation = staffDesiqnation;
	}
	public double getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(double staffSalary) {
		this.staffSalary = staffSalary;
	}

	public Date getStaffDateOfJoining() {
		return staffDateOfJoining;
	}

	public void setStaffDateOfJoining(Date staffDateOfJoining) {
		this.staffDateOfJoining = staffDateOfJoining;
	}
	
	
}
