package com.thbs.ijp.constraint;

public class RecordNotFoundException extends Exception {

	private int user_id;
	public RecordNotFoundException(String st) {
	        super(String.format("User is not found with id : '%s'", st));
	        }
}

