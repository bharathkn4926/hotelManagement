package com.roomdetails.service;

import java.util.List;
import java.util.Optional;

import com.roomdetails.model.RoomDetails;


public interface RoomService {

	public List<RoomDetails> getAllRoomDetails();
	public RoomDetails addRoomDetails(RoomDetails newroom);
	public String deleteRoomDetails(int roomId);
	public RoomDetails updateRoomDetails(RoomDetails room);
	public Optional<RoomDetails> getRoomDetailsById(int roomId);
	public List<RoomDetails> findByRoomAvailability(String roomAvailability);
	
	
}
