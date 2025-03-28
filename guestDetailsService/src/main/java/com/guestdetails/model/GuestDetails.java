package com.guestdetails.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "Guest_Details")
public class GuestDetails {
	
	@Transient
	public static final String SEQUENCE_NAME="guestDetails_sequence";

	@Id
	private int guestId;
	
	@NotNull
	@NotBlank(message = "Enter the Guest name")
	private String guestName;
	
	@NotNull
	@NotBlank(message = "Enter the Guest Phone number")
	private String guestPhoneNumber;
	
	@NotNull
	@NotBlank(message = "Enter valid email Id")
	@Email
	private String guestEmailId;
	
	@NotNull
	@NotBlank(message = "Enter the Guest Identity card type")
	private String guestIdentityCardType;
	
	@NotNull
	@NotBlank(message = "Enter the Guest Identity card number")
	private String guestIdentityCardNumber;
	
	@NotNull
	@NotBlank(message = "Enter the Guest address details")
	private String guestAddress;
	
	@NotNull(message = "Enter the Number of people")
	private int guestNumberOfPeople;
	
	@NotNull
	@NotBlank(message = "Enter the required room type")
	private String requiredRoomType;
	
	@NotNull(message = "Enter the room number assigned to guest")
	private int guestRoomNumber;
	
	@NotNull(message="Enter the total amount to be paid ")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date  guestCheckinDate;
	
	@NotNull(message = "Enter the advance amount paid by the guest")
	private double guestAdvancePaid;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date guestCheckoutDate;
	private double guestTotalAmountPaid;
	

	public Date getGuestCheckoutDate() {
		return guestCheckoutDate;
	}

	public void setGuestCheckoutDate(Date guestCheckoutDate) {
		this.guestCheckoutDate = guestCheckoutDate;
	}

	

	public double getGuestTotalAmountPaid() {
		return guestTotalAmountPaid;
	}

	public void setGuestTotalAmountPaid(double guestTotalAmountPaid) {
		this.guestTotalAmountPaid = guestTotalAmountPaid;
	}

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

	

	public Date getGuestCheckinDate() {
		return guestCheckinDate;
	}

	public void setGuestCheckinDate(Date guestCheckinDate) {
		this.guestCheckinDate = guestCheckinDate;
	}

	public double getGuestAdvancePaid() {
		return guestAdvancePaid;
	}

	public void setGuestAdvancePaid(double guestAdvancePaid) {
		this.guestAdvancePaid = guestAdvancePaid;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public GuestDetails(int guestId,String guestName,String guestPhoneNumber,String guestEmailId,
			String guestIdentityCardType,String guestIdentityCardNumber,String guestAddress,int guestNumberOfPeople,String requiredRoomType,
			int guestRoomNumber,Date guestCheckinDate,double guestAdvancePaid) {
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
		this.guestCheckinDate = guestCheckinDate;
		this.guestAdvancePaid = guestAdvancePaid;
	}
	
	public GuestDetails() {
		
	}

}
