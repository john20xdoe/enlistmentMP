package com.orangeandbronze.enlistment.domain;

public class DuplicateSectionException extends RuntimeException {

	public DuplicateSectionException() {
	}

	public DuplicateSectionException(String message) {
		super(message);
	}

	public DuplicateSectionException(Throwable cause) {
		super(cause);
	}

	public DuplicateSectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateSectionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
