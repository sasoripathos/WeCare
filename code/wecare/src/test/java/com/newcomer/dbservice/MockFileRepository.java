package com.newcomer.dbservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newcomer.entity.MockFile;

public interface MockFileRepository extends MongoRepository<MockFile, String> {

}
