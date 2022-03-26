package com.fis.java.exception;

public class BankTransactionException extends Exception {

	private static final long serialVersionUID = 1539307050955809749L;

	public BankTransactionException(String message) {
		super(message);
	}

}
