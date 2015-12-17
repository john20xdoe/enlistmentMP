package com.orangeandbronze.enlistment.domain;

public class RoomFullException extends RuntimeException {

	public RoomFullException() {
	}

	public RoomFullException(String message) {
		super(message);
	}

	public RoomFullException(Throwable cause) {
		super(cause);
	}

	public RoomFullException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoomFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
