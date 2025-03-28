package com.roomdetails;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roomdetails.model.RoomDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomDetailsTests {
	
	@Test
	public void setRoomIdTest() {
		RoomDetails r=new RoomDetails();
		r.setRoomId(1);
		assertEquals(1,r.getRoomId() );
	}

	@Test
	public void setRoomType() {
		RoomDetails r=new RoomDetails();
		r.setRoomType("Single Bed Room");
		assertEquals("Single Bed Room",r.getRoomType());
	}
	
	@Test
	public void setRoomAvailability() {
		RoomDetails r=new RoomDetails();
		r.setRoomAvailability("Available");
		assertEquals("Available", r.getRoomAvailability());
	}
	
	@Test
	public void setRoomCost() {
		RoomDetails r=new RoomDetails();
		r.setRoomCost(1000.0);
		assertEquals(1000.0, r.getRoomCost(),0.0);
	}
}
