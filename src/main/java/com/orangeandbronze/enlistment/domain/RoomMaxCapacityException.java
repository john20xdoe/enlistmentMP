package com.orangeandbronze.enlistment.domain;

public class RoomMaxCapacityException extends RuntimeException{

	public RoomMaxCapacityException(String message){
		super(message);
	}
	
	public RoomMaxCapacityException(String message, Exception e){
		super(message,e);
	}
}
