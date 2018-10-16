package com.newcomer.dbservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newcomer.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	/**
	 * Find a user by email.
	 * @param email
	 * @return User if found, None otherwise.
	 */
	public User findByEmail(String email);
}
