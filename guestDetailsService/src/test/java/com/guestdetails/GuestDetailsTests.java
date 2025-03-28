package com.guestdetails;

import static org.hamcrest.CoreMatchers.is;

/*import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guestdetails.model.GuestDetails;
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guestdetails.model.GuestDetails;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestDetailsTests {

private  GuestDetails guest;
	
	
	@Test
	public void setGuestIdTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestId(1);
		assertEquals(g.getGuestId(), 1);
	}
	@Test
	public void setGuestNameTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestName("Bharath");
		assertEquals(g.getGuestName(),"Bharath");
	}
	@Test
	public void setGuestPhoneNumberTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestPhoneNumber("1234567890");
		assertEquals(g.getGuestPhoneNumber(),"1234567890");
	}
	@Test
	public void setGuestEmailIdTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestEmailId("bharath@gmail.com");
		assertEquals(g.getGuestEmailId(),"bharath@gmail.com");
	}
	@Test
	public void setGuestIdentityCardTypeTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestIdentityCardType("PANCARD");
		assertEquals(g.getGuestIdentityCardType(),"PANCARD");
	}
	@Test
	public void setGuestIdentityCardNumberTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestIdentityCardNumber("12345678");
		assertEquals(g.getGuestIdentityCardNumber(),"12345678");
	}
	@Test
	public void setGuestAddressTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestAddress("Tumkur");
		assertEquals(g.getGuestAddress(),"Tumkur");
	}
	@Test
	public void setGuestNumberOfPeopleTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestNumberOfPeople(3);
		assertEquals(g.getGuestNumberOfPeople(), 3);
	}

	
	 @Test public void setRequiredRoomTypeTest() { 
		 GuestDetails g=new GuestDetails();
		 g.setRequiredRoomType("Single bed room");
	      assertEquals(g.getRequiredRoomType(), "Single bed room"); }
	
	@Test
	public void setGuestRoomNumberTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestRoomNumber(1);
		assertEquals(g.getGuestRoomNumber(), 1);
	}
	
	@Test
	public void setGuestAdvancePaidTest() {
		GuestDetails g=new GuestDetails();
		g.setGuestAdvancePaid(500.0);
		assertEquals(g.getGuestAdvancePaid(), 500.0,0.0);
	}
	@Test
	public void setGuestCheckinDate() {
		GuestDetails g=new GuestDetails();
		g.setGuestCheckinDate(null);
		assertEquals(g.getGuestCheckinDate(),null);
	}

	
}
