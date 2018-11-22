package com.newcomer.exception;

public class InvalidParameterException extends Exception {

	private static final long serialVersionUID = 3641623187038979268L;

	public InvalidParameterException() {
		this("Invalid Parameters!");
	}

	public InvalidParameterException(String message) {
		super(message);
	}
	

}
