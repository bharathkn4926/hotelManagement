package com.receptionist.model;

public class RoomDetails {
	
	
	private int roomId;	
	private String roomType;
	private String roomAvailability;	
	private String roomStatus;
	private double roomCost;
	
	
	public RoomDetails() {
		super();
	}
	
	public RoomDetails(int roomId, String roomType, String roomAvailability, String roomStatus, double roomCost) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomAvailability = roomAvailability;
		this.roomStatus = roomStatus;
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
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public double getRoomCost() {
		return roomCost;
	}
	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}
	
}
