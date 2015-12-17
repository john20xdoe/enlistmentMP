package com.orangeandbronze.enlistment.domain;

public class ScheduleConflictException extends RuntimeException{
	
	public ScheduleConflictException(String message){
		super(message);
	}
	
	public ScheduleConflictException(String message, Exception e){
		super(message,e);
	}
}
