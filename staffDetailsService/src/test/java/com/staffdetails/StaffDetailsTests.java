package com.staffdetails;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.staffdetails.model.StaffDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffDetailsTests {
	
	@Test
	public void setStaffId() {
		StaffDetails s=new StaffDetails();
		s.setStaffId(1);
		assertEquals(1,s.getStaffId());
	}
	
	@Test
	public void setStaffName() {
		StaffDetails s=new StaffDetails();
		s.setStaffName("Bharath");
		assertEquals("Bharath",s.getStaffName());
	}
	
	@Test
	public void setStaffPhoneNumber() {
		StaffDetails s=new StaffDetails();
		s.setStaffPhoneNumber("7406245625");
		assertEquals("7406245625",s.getStaffPhoneNumber());
	}
	
	@Test
	public void setStaffEmailId() {
		StaffDetails s=new StaffDetails();
		s.setStaffEmailId("bharath@gmail.com");
		assertEquals("bharath@gmail.com",s.getStaffEmailId());
	}
	
	@Test
	public void setStaffAddress() {
		StaffDetails s=new StaffDetails();
		s.setStaffAddress("Tumkur");
		assertEquals("Tumkur",s.getStaffAddress());
	}
	
	@Test
	public void setStaffDesiqnation() {
		StaffDetails s=new StaffDetails();
		s.setStaffDesiqnation("Manager");
		assertEquals("Manager",s.getStaffDesiqnation());
	}
	
	@Test
	public void setStaffSalary() {
		StaffDetails s=new StaffDetails();
		s.setStaffSalary(30000.0);
		assertEquals(30000.0,s.getStaffSalary(),0.0);
	}
	

}
