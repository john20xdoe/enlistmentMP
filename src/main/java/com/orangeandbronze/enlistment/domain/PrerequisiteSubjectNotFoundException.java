package com.orangeandbronze.enlistment.domain;

public class PrerequisiteSubjectNotFoundException extends RuntimeException {

	public PrerequisiteSubjectNotFoundException() {
	}

	public PrerequisiteSubjectNotFoundException(String message) {
		super(message);
	}

	public PrerequisiteSubjectNotFoundException(Throwable cause) {
		super(cause);
	}

	public PrerequisiteSubjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrerequisiteSubjectNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
