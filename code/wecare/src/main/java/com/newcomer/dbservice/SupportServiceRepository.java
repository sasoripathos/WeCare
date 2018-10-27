package com.newcomer.dbservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newcomer.entity.SupportService;

public interface SupportServiceRepository extends MongoRepository<SupportService, String> {
	public SupportService findByIdentifierValue(String identifierValue);
}
