package com.newcomer.exception;

public class UserExistedException extends Exception {

	private static final long serialVersionUID = 8608511530394028885L;

	public UserExistedException(String email) {
		super("Email: " + email + " has been used by another user!");
	}
}
