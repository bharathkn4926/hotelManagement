package com.roomdetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.roomdetails.model.RoomDetails;
import com.roomdetails.repository.RoomRepository;
import com.roomdetails.service.RoomService;
import com.roomdetails.serviceimpl.RoomDetailsServiceImpl;
import com.roomdetails.serviceimpl.SequenceGeneratorService;

@SpringBootTest
public class RoomDetailsServiceTests {

	@InjectMocks
	RoomService roomservice = new RoomDetailsServiceImpl();

	@Mock
	RoomRepository roomrepo;
	@Mock
	SequenceGeneratorService seqService;
	
	private RoomDetails room;

	@Test
	public void getAllRoomDetails() {
		RoomDetails room = new RoomDetails();
		room.setRoomType("Single Bed Room");
		room.setRoomAvailability("Available");
		
		room.setRoomCost(1000.0);

		RoomDetails room2 = new RoomDetails();
		room2.setRoomType("Double Bed Room");
		room2.setRoomAvailability("Available");
		
		room2.setRoomCost(2000.0);

		List<RoomDetails> roomdetails = new ArrayList<>();
		roomdetails.add(room);
		roomdetails.add(room2);

		when(roomrepo.findAll()).thenReturn(roomdetails);
		List<RoomDetails> roomlist = roomservice.getAllRoomDetails();
		assertNotNull(roomlist);
		assertEquals(2, roomlist.size());
	}

	
	  @Test public void addRoomDetails() { RoomDetails room=new RoomDetails();
	  room.setRoomType("Single Bed Room"); room.setRoomAvailability("Available");
	   room.setRoomCost(1000.0);
	  room.setRoomId(seqService.getSequenceNumber(RoomDetails.SEQUENCE_NAME));
	  
	  when(roomrepo.save(room)).thenReturn(room); RoomDetails
	  roomdetails=roomservice.addRoomDetails(room); assertNotNull(roomdetails);
	  assertEquals("Single Bed Room", roomdetails.getRoomType()); }
	  
	  @Test 
	  public void deleteRoomDetails() { RoomDetails room=new RoomDetails();
	  room.setRoomType("Single Bed Room"); room.setRoomAvailability("Available");
	  room.setRoomCost(1000.0);
	  room.setRoomId(seqService.getSequenceNumber(RoomDetails.SEQUENCE_NAME));
	  
	  roomrepo.findById(room.getRoomId()); roomrepo.deleteById(room.getRoomId());
	  verify(roomrepo,times(1)).deleteById(0);
	  
	  }
	  
	  @Test
		public void constructorTest() {
		  room=new RoomDetails(1,"Single Bed Room","Available",2000.0);
		  assertThat("Single Bed Room",is(room.getRoomType()));
		  
	  }
	 
}
