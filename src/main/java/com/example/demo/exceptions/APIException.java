package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	private HttpStatus status;
	
	public APIException(String message, HttpStatus status) {
		this.errorMessage = message;
		this.status = status;
	}
}
