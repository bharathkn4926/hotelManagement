package com.guestdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guestdetails.model.GuestDetails;

public interface GuestDetailsRepository extends MongoRepository<GuestDetails, Integer> {
	
	

}
