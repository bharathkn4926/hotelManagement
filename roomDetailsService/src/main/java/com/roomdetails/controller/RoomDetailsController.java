package com.roomdetails.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roomdetails.model.RoomDetails;
import com.roomdetails.repository.RoomRepository;
import com.roomdetails.service.RoomService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rooms")
public class RoomDetailsController {

	@Autowired
	RoomRepository roomrepo;
	
	@Autowired
	RoomService roomservice;
	
	private static final Logger logger = LoggerFactory.getLogger(RoomDetails.class);
	
	@GetMapping("/getAllRoomDetails")
	public ResponseEntity<List<RoomDetails>> getAllRoomDetails(){
		logger.info("Inside getAllRoomDetails() method of RoomDetailsController");
		List<RoomDetails> list= roomservice.getAllRoomDetails();
		return new ResponseEntity<List<RoomDetails>>(list,HttpStatus.OK);
	}
	@GetMapping("/getRoomDetailsById/{roomId}")
	public ResponseEntity<RoomDetails> getRoomDetailsById(@PathVariable int roomId){
		logger.info("Inside getRoomDetailsById() method of RoomDetailsController");
		Optional<RoomDetails> room=roomservice.getRoomDetailsById(roomId);
		return new ResponseEntity<RoomDetails>(room.get(),HttpStatus.OK);
	}
	
	@PostMapping("/addNewRoomDetails")
	public ResponseEntity<RoomDetails> addRoomDetails(@RequestBody RoomDetails newroom) {
		logger.info("Inside addRoomDetails() method of RoomDetailsController");
		RoomDetails room= roomservice.addRoomDetails(newroom);
		return new ResponseEntity<RoomDetails>(room,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteRoomDetails/{roomId}")
	public ResponseEntity<String> deleteRoomDetails(@PathVariable int roomId) {
		logger.info("Inside deleteRoomDetails() method of RoomDetailsController");
		roomservice.deleteRoomDetails(roomId);
		return new ResponseEntity<String>("Room details deleted sucessfully",HttpStatus.OK);
	}	
	
	@PutMapping("/updateRoomDetails")
	public ResponseEntity<RoomDetails> updateRoomDetails(@RequestBody RoomDetails room) {
		logger.info("Inside updateRoomDetails() method of RoomDetailsController");
		Optional<RoomDetails> _room=roomservice.getRoomDetailsById(room.getRoomId());
		return new ResponseEntity<RoomDetails>(roomservice.updateRoomDetails( room),HttpStatus.OK);
	}
	@GetMapping("/getroombyavailability/{roomAvailability}")
	public ResponseEntity<List<RoomDetails>> getroombyavailability(@PathVariable String roomAvailability){
	List<RoomDetails> rooms=	roomservice.findByRoomAvailability(roomAvailability);
		return new ResponseEntity<List<RoomDetails>>(rooms,HttpStatus.OK);
	}
}

