package com.newcomer.dbservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newcomer.entity.NeedAssessRef;

public interface NeedAssessRefRepository extends MongoRepository<NeedAssessRef, String> {
	public NeedAssessRef findByIdentifierValue(String identifierValue);
}
