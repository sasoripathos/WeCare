package com.newcomer.dbservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newcomer.entity.Newcomer;

public interface NewcomerRepository extends MongoRepository<Newcomer, String> {
	public Newcomer findByIdentifierValue(String identifierValue);
}
