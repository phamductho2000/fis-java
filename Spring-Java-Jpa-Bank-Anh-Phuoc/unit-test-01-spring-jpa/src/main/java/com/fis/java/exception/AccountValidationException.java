package com.fis.java.exception;

public class AccountValidationException extends Exception{

	private static final long serialVersionUID = 485772015789863725L;
	
	public AccountValidationException(String message) {
		super(message);
	}

}
