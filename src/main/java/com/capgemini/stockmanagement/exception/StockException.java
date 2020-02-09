package com.capgemini.stockmanagement.exception;



public class StockException extends RuntimeException {
	
	
	String message;

	public StockException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	

}
