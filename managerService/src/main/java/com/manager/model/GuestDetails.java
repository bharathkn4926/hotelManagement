package com.manager.model;




public class GuestDetails {
	
	private int guestId;	
	private String guestName;		
	private String guestPhoneNumber;		
	private String guestEmailId;	
	private String guestIdentityCardType;	
	private String guestIdentityCardNumber;		
	private String guestAddress;
	private int guestNumberOfPeople;
	private String requiredRoomType;
	private int guestRoomNumber;
	private double guestTotalAmount;
	private double guestAdvancePaid;

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestPhoneNumber() {
		return guestPhoneNumber;
	}

	public void setGuestPhoneNumber(String guestPhoneNumber) {
		this.guestPhoneNumber = guestPhoneNumber;
	}

	public String getGuestEmailId() {
		return guestEmailId;
	}

	public void setGuestEmailId(String guestEmailId) {
		this.guestEmailId = guestEmailId;
	}

	public String getGuestIdentityCardType() {
		return guestIdentityCardType;
	}

	public void setGuestIdentityCardType(String guestIdentityCardType) {
		this.guestIdentityCardType = guestIdentityCardType;
	}

	public String getGuestIdentityCardNumber() {
		return guestIdentityCardNumber;
	}

	public void setGuestIdentityCardNumber(String guestIdentityCardNumber) {
		this.guestIdentityCardNumber = guestIdentityCardNumber;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public int getGuestNumberOfPeople() {
		return guestNumberOfPeople;
	}

	public void setGuestNumberOfPeople(int guestNumberOfPeople) {
		this.guestNumberOfPeople = guestNumberOfPeople;
	}

	public String getRequiredRoomType() {
		return requiredRoomType;
	}

	public void setRequiredRoomType(String requiredRoomType) {
		this.requiredRoomType = requiredRoomType;
	}

	public int getGuestRoomNumber() {
		return guestRoomNumber;
	}

	public void setGuestRoomNumber(int guestRoomNumber) {
		this.guestRoomNumber = guestRoomNumber;
	}

	public double getGuestTotalAmount() {
		return guestTotalAmount;
	}

	public void setGuestTotalAmount(double guestTotalAmount) {
		this.guestTotalAmount = guestTotalAmount;
	}

	public double getGuestAdvancePaid() {
		return guestAdvancePaid;
	}

	public void setGuestAdvancePaid(double guestAdvancePaid) {
		this.guestAdvancePaid = guestAdvancePaid;
	}



	public GuestDetails(int guestId,String guestName,String guestPhoneNumber,String guestEmailId,
			String guestIdentityCardType,String guestIdentityCardNumber,String guestAddress,int guestNumberOfPeople,String requiredRoomType,
			int guestRoomNumber,double guestTotalAmount,double guestAdvancePaid) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestPhoneNumber = guestPhoneNumber;
		this.guestEmailId = guestEmailId;
		this.guestIdentityCardType = guestIdentityCardType;
		this.guestIdentityCardNumber = guestIdentityCardNumber;
		this.guestAddress = guestAddress;
		this.guestNumberOfPeople = guestNumberOfPeople;
		this.requiredRoomType = requiredRoomType;
		this.guestRoomNumber = guestRoomNumber;
		this.guestTotalAmount = guestTotalAmount;
		this.guestAdvancePaid = guestAdvancePaid;
	}
	
	public GuestDetails() {
		
	}

}
