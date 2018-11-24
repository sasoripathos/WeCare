package com.newcomer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Document class for system user data.
 */
@Document(collection="User")
public class User {
	/**
	 * Unique ID.
	 */
	@Id
	String id;
	
	/**
	 * User's real name.
	 */
	String name;
	
	/**
	 * User's email, unique for login purpose.
	 */
	String email;
	
	/**
	 * User's role, one of Agency, Government, UTSC.
	 */
	String role;
	
	/**
	 * User' login password
	 */
	String password;
	
	/**
	 * The agency name this user belongs to, only applicable when the role is "Agency".
	 */
	String agency;
	
	public User() {
		
	}

	public User(String name, String email, String role, String password, String agency) {
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
		this.agency = agency;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

}
