package com.staffdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.staffdetails.model.StaffDetails;

public interface StaffDetailRepository extends MongoRepository<StaffDetails, Integer> {

}
