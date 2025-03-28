package com.roomdetails.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Room_Details")
public class RoomDetails {
	
	@Transient
	public static final String SEQUENCE_NAME="guestDetails_sequence";
	
	@Id
	private int roomId;
	
	@NotNull
	@NotBlank(message = "Enter the Room typr")
	private String roomType;
	@NotNull
	@NotBlank(message = "Enter the Room Availability")
	private String roomAvailability;
	@NotNull
	@NotBlank(message = "Enter the room cost")
	private double roomCost;
	
	
	public RoomDetails() {
		super();
	}
	
	public RoomDetails(int roomId, String roomType, String roomAvailability, double roomCost) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomAvailability = roomAvailability;
		
		this.roomCost = roomCost;
	}
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomAvailability() {
		return roomAvailability;
	}
	public void setRoomAvailability(String roomAvailability) {
		this.roomAvailability = roomAvailability;
	}
	
	public double getRoomCost() {
		return roomCost;
	}
	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}
	
}
