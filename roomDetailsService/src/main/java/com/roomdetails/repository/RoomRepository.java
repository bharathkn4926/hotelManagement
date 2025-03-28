package com.roomdetails.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.roomdetails.model.RoomDetails;

public interface RoomRepository extends MongoRepository<RoomDetails, Integer> {
	public List<RoomDetails> findByRoomAvailability(String roomAvailability);

}
