package com.guestdetails.serviceimplementation;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.guestdetails.customeException.EmptyInputException;
import com.guestdetails.customeException.EmptyListException;
import com.guestdetails.model.GuestDetails;
import com.guestdetails.repository.GuestDetailsRepository;
import com.guestdetails.service.GuestDetailsService;

@Service

public class GuestDetailsServiceImpl implements GuestDetailsService{
	
	
	@Autowired
	GuestDetailsRepository guestRepo;
	

	@Autowired
	SequenceGeneratorService seqService;

	@Override
	public List<GuestDetails> getAllGuestDetails(){

			System.out.println("Inside getAllGuestDetails() method of GuestDetailsController");
			List<GuestDetails> list=guestRepo.findAll();
			if(list.isEmpty()) {
			
				throw new EmptyListException();
			}
			return list;
	}

	
	@Override
	public GuestDetails addGuestDetails(GuestDetails newguest) 
	{   
		   if(newguest.getGuestName().isEmpty()||newguest.getGuestAddress().isEmpty()
				   ||newguest.getGuestEmailId().isEmpty()||newguest.getGuestIdentityCardType().isEmpty()
				   ||newguest.getGuestIdentityCardNumber().isEmpty()
				   ||newguest.getGuestPhoneNumber().isEmpty()||newguest.getGuestNumberOfPeople()<=0
				   ||newguest.getGuestRoomNumber()<=0||newguest.getGuestAdvancePaid()<=0) 
			   
			   throw new EmptyInputException();
		   
			System.out.println("Inside addGuestDetails() method of GuestDetailsController");
			newguest.setGuestId(seqService.getSequenceNumber(GuestDetails.SEQUENCE_NAME));
			return guestRepo.save(newguest);
			
		
	}
		

	
	  @Override
	  public String deleteGuestDetails(int guestId)  throws MethodArgumentTypeMismatchException {
	  
	  if(guestId<=0) throw new IllegalStateException();
	  
	  if(guestRepo.findById(guestId).get()==null) throw new
	  NoSuchElementException();
	  
	  
	  System.out.println("Inside deleteGuestDetails() method of GuestDetailsController");
	  guestRepo.deleteById(guestId); 
	  return "Data deleted sucessfully";
	  
	  
	  }
	 
	
	
		
	
	

	@Override
	public GuestDetails updateGuestDetails(GuestDetails guest) throws IllegalStateException,NoSuchElementException {
		System.out.println("Inside updateGuestDetails() method of GuestDetailsController");
		Optional<GuestDetails> guestData=guestRepo.findById(guest.getGuestId());
		
		GuestDetails _guest=guestData.get();
		
		_guest.setGuestName(guest.getGuestName());
		_guest.setGuestPhoneNumber(guest.getGuestPhoneNumber());
		_guest.setGuestEmailId(guest.getGuestEmailId());
		_guest.setGuestIdentityCardType(guest.getGuestIdentityCardType());
		_guest.setGuestIdentityCardNumber(guest.getGuestIdentityCardNumber());
		_guest.setGuestAddress(guest.getGuestAddress());
		_guest.setGuestNumberOfPeople(guest.getGuestNumberOfPeople());
		_guest.setRequiredRoomType(guest.getRequiredRoomType());
		_guest.setGuestRoomNumber(guest.getGuestRoomNumber());
		_guest.setGuestCheckinDate(guest.getGuestCheckinDate());
		_guest.setGuestAdvancePaid(guest.getGuestAdvancePaid());
		_guest.setGuestCheckoutDate(guest.getGuestCheckoutDate());
		_guest.setGuestTotalAmountPaid(guest.getGuestTotalAmountPaid());
		
		if(_guest.getGuestName().isEmpty()||_guest.getGuestAddress().isEmpty()
				   ||_guest.getGuestEmailId().isEmpty()||_guest.getGuestIdentityCardType().isEmpty()||_guest.getGuestIdentityCardNumber().isEmpty()
				   ||_guest.getGuestPhoneNumber().isEmpty()
				   ||_guest.getGuestAdvancePaid()<=0||_guest.getGuestNumberOfPeople()<=0
				   ||_guest.getGuestAdvancePaid()<=0) throw new EmptyInputException();
		
		return guestRepo.save(_guest);
		
		
	}

	@Override
	public Optional<GuestDetails> getGuestDetailsById(int guestId) throws NoSuchElementException,IllegalStateException,MethodArgumentTypeMismatchException  {	
		 return guestRepo.findById(guestId);
	}

	

	
	

}
