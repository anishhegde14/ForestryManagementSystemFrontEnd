package com.capgemini.stockmanagement.exception;

public class CompanyException extends RuntimeException {

	String message;

	public CompanyException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
}
