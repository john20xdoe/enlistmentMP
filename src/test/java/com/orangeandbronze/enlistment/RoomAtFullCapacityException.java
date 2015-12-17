package com.orangeandbronze.enlistment;

public class RoomAtFullCapacityException extends RuntimeException {

	public RoomAtFullCapacityException() {

	}

	public RoomAtFullCapacityException(String message) {
		super(message);

	}

	public RoomAtFullCapacityException(Throwable cause) {
		super(cause);

	}

	public RoomAtFullCapacityException(String message, Throwable cause) {
		super(message, cause);

	}

	public RoomAtFullCapacityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
