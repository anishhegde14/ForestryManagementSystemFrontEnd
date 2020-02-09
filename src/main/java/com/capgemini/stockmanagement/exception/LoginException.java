package com.capgemini.stockmanagement.exception;

public class LoginException extends RuntimeException {
	
	String message;

	public LoginException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
	

	
}
