package com.app.dao.exception;

public class DataNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException() {
	}
	
	public DataNotFoundException(String message, Throwable cause) {
	 super(message, cause);
	}

}
