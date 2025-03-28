package com.guestdetails.service;

import java.util.List;
import java.util.Optional;

import com.guestdetails.model.GuestDetails;

public interface GuestDetailsService {

	
	public List<GuestDetails> getAllGuestDetails();
	public GuestDetails addGuestDetails(GuestDetails newguest);
	public String deleteGuestDetails(int guestId);
	
	public GuestDetails updateGuestDetails(GuestDetails guest);
	public Optional<GuestDetails> getGuestDetailsById(int guestId);
	
}
