package com.roomdetails.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.roomdetails.customeException.EmptyInputException;
import com.roomdetails.customeException.EmptyListException;
import com.roomdetails.model.RoomDetails;
import com.roomdetails.repository.RoomRepository;
import com.roomdetails.service.RoomService;

@Service
public class RoomDetailsServiceImpl implements RoomService{
	
	@Autowired
	RoomService roomservice;
	
	@Autowired
	RoomRepository roomrepo;
	
	@Autowired
	SequenceGeneratorService seqService;


	@Override
	public List<RoomDetails> getAllRoomDetails() {
		System.out.println("Inside getAllRoomDetails() method of RoomDetailsController");
		List<RoomDetails> list=roomrepo.findAll();
		if(list.isEmpty()) throw new EmptyListException();
		return list;
	}

	@Override
	public RoomDetails addRoomDetails(RoomDetails room) {
		System.out.println("Inside addRoomDetails() method of RoomDetailsController");
		room.setRoomId(seqService.getSequenceNumber(RoomDetails.SEQUENCE_NAME));
		
		if(room.getRoomType().isEmpty()||room.getRoomAvailability().isEmpty()
				||room.getRoomCost()<=0)
			throw new EmptyInputException();
		return roomrepo.save(room);
		
	}

	@Override
	public String deleteRoomDetails(int roomId) throws MethodArgumentTypeMismatchException  {
		
		if(roomId<=0) throw new IllegalStateException();	
		if(roomrepo.findById(roomId).get()==null) throw new NoSuchElementException();
		
		System.out.println("Inside deleteRoomDetails() method of RoomDetailsController");
		roomrepo.deleteById(roomId);
		return "Room Details deleted sucessfully";
		
	}

	@Override
	public RoomDetails updateRoomDetails(RoomDetails room) throws IllegalStateException,NoSuchElementException  {
		System.out.println("Inside updateRoomDetails() method of RoomDetailsController");
		Optional<RoomDetails> roomdata=roomrepo.findById(room.getRoomId());
		
		RoomDetails _room=roomdata.get();
		_room.setRoomType(room.getRoomType());
		_room.setRoomAvailability(room.getRoomAvailability());
		_room.setRoomCost(room.getRoomCost());
		
		if(_room.getRoomType().isEmpty()||_room.getRoomAvailability().isEmpty()
				||_room.getRoomCost()<=0)
			throw new EmptyInputException();
		
		return roomrepo.save(_room);
	}

	
	

	@Override
	public Optional<RoomDetails> getRoomDetailsById(int roomId) throws IllegalStateException,NoSuchElementException,MethodArgumentTypeMismatchException   {
		
		return roomrepo.findById(roomId);
	}

	@Override
	public 	List<RoomDetails> findByRoomAvailability(String roomAvailability) {
		
		return roomrepo.findByRoomAvailability(roomAvailability);
	}

	

}
