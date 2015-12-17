package com.orangeandbronze.enlistment.domain;

public class SemesterSectionMismatch extends RuntimeException {

	public SemesterSectionMismatch() {
	}

	public SemesterSectionMismatch(String message) {
		super(message);
	
	}

	public SemesterSectionMismatch(Throwable cause) {
		super(cause);
	
	}

	public SemesterSectionMismatch(String message, Throwable cause) {
		super(message, cause);
	
	}

	public SemesterSectionMismatch(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
