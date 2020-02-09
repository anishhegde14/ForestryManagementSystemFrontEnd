package com.capgemini.stockmanagement.exception;

public class ManagerException  extends RuntimeException{

	
	String message;

	public ManagerException(String message) {
		this.message = message;

	}

	@Override
	public String getMessage() {
		return this.message;
	}
}