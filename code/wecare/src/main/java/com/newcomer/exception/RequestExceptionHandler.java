package com.newcomer.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler {
	
	@ExceptionHandler(InvalidParameterException.class)
	public ResponseEntity<ExceptionResponse> invalidParameterResponse(HttpServletRequest request, InvalidParameterException excep) {
		ExceptionResponse resp = new ExceptionResponse();
		resp.setStatus(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(excep.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserExistedException.class)
	public ResponseEntity<ExceptionResponse> userExistedResponse(HttpServletRequest request, UserExistedException excep) {
		ExceptionResponse resp = new ExceptionResponse();
		resp.setStatus(HttpStatus.BAD_REQUEST.value());
		resp.setMessage(excep.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
