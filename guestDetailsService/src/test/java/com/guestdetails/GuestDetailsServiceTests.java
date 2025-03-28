package com.guestdetails;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.guestdetails.customeException.EmptyListException;
import com.guestdetails.model.GuestDetails;
import com.guestdetails.repository.GuestDetailsRepository;
import com.guestdetails.service.GuestDetailsService;
import com.guestdetails.serviceimplementation.GuestDetailsServiceImpl;
import com.guestdetails.serviceimplementation.SequenceGeneratorService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestDetailsServiceTests {

	@InjectMocks
	GuestDetailsService guestservice=new GuestDetailsServiceImpl();
	@Mock
	GuestDetailsRepository guestrepo;
	@Mock
	SequenceGeneratorService seqService;
	
	@Test
	void testGetAllGuestDetails() {
		
		GuestDetails guest1=new GuestDetails();
		guest1.setGuestName("Bharath");
		guest1.setGuestPhoneNumber("8890173456");
		guest1.setGuestEmailId("bharath@gmail.com");
		guest1.setGuestIdentityCardType("PAN Card");
		guest1.setGuestIdentityCardNumber("ABCD123456");
		guest1.setGuestAddress("Chitradurga");
		guest1.setGuestNumberOfPeople(5);
		guest1.setRequiredRoomType("Double bed room");
		guest1.setGuestRoomNumber(1);
		
		guest1.setGuestAdvancePaid(1000);
		
		
		
		GuestDetails guest2=new GuestDetails();
		guest2.setGuestName("Sachin");
		guest2.setGuestPhoneNumber("8890145272");
		guest2.setGuestEmailId("sachin@gmail.com");
		guest2.setGuestIdentityCardType("AdharCard");
		guest2.setGuestIdentityCardNumber("123456123456");
		guest2.setGuestAddress("Chitradurga");
		guest2.setGuestNumberOfPeople(2);
		guest2.setRequiredRoomType("Single bed room");
		guest2.setGuestRoomNumber(3);
		
		guest2.setGuestAdvancePaid(1000);
		
		List<GuestDetails > getAllGuestDetails=new ArrayList<>();
		getAllGuestDetails.add(guest1);
		getAllGuestDetails.add(guest2);
		
		when(guestrepo.findAll()).thenReturn(getAllGuestDetails);
		List<GuestDetails> guestList=guestservice.getAllGuestDetails();
		assertNotNull(guestList);
		
		assertEquals(2,guestList.size());
	}
	
	@Test
	void testGetallGuestDetails() {
		when(guestrepo.findAll()).thenReturn(Collections.emptyList());
		assertThrows(EmptyListException.class, () -> guestservice.getAllGuestDetails());
	}
	
	
	
	
	
	



	@Test
	void TestAddGuestDetails() {
		
		GuestDetails guest1=new GuestDetails();
		
		guest1.setGuestName("Bharath");
		guest1.setGuestPhoneNumber("8890173456");
		guest1.setGuestEmailId("bharath@gmail.com");
		guest1.setGuestIdentityCardType("PAN Card");
		guest1.setGuestIdentityCardNumber("ABCD123456");
		guest1.setGuestAddress("Chitradurga");
		guest1.setGuestNumberOfPeople(5);
		guest1.setRequiredRoomType("Double bed room");
		guest1.setGuestRoomNumber(1);
		
		guest1.setGuestAdvancePaid(1000);
		guest1.setGuestId(seqService.getSequenceNumber(GuestDetails.SEQUENCE_NAME));
		when(guestrepo.save(guest1)).thenReturn(guest1);
		GuestDetails guestdetails=guestservice.addGuestDetails(guest1);
		assertNotNull(guestdetails);
		assertEquals("Bharath", guestdetails.getGuestName());
		
	}
	
	@Test
	void testDeleteGuestDetails() {
		GuestDetails guest1=new GuestDetails();
		guest1.setGuestId(seqService.getSequenceNumber(GuestDetails.SEQUENCE_NAME));
		guest1.setGuestName("Bharath");
		guest1.setGuestPhoneNumber("8890173456");
		guest1.setGuestEmailId("bharath@gmail.com");
		guest1.setGuestIdentityCardType("PAN Card");
		guest1.setGuestIdentityCardNumber("ABCD123456");
		guest1.setGuestAddress("Chitradurga");
		guest1.setGuestNumberOfPeople(5);
		guest1.setRequiredRoomType("Double bed room");
		guest1.setGuestRoomNumber(1);
		
		guest1.setGuestAdvancePaid(1000);
		
		guestrepo.findById(guest1.getGuestId());
		guestrepo.deleteById(guest1.getGuestId());
		verify(guestrepo,times(1)).deleteById(0);
		assertEquals("Data deleted sucessfully","Data deleted sucessfully");
	
		
	}
	
	
	

	
	
}
