package com.staffdetails.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "Staff_Details")
public class StaffDetails {
	
	@Transient
	public static final String SEQUENCE_NAME="guestDetails_sequence";
	
	@Id
	public int staffId;
	@NotNull
	@NotBlank(message = "Enter the staff name")
	public String staffName;
	
	@NotNull
	@NotBlank(message = "Enter the staff phone number")
	public String staffPhoneNumber;
	
	@NotNull
	@NotBlank(message = "Enter the staff mail Id")
	public String staffEmailId;
	
	@NotNull
	@NotBlank(message = "Enter the staff address")
	public String staffAddress;
	
	@NotNull
	@NotBlank(message = "Enter the staff designation")
	public String staffDesiqnation;
	
	@NotNull
	@NotBlank(message = "Enter the staff salary")
	public double staffSalary;
	
	@NotNull
	@NotBlank(message = "Enter the staff joining date")
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
