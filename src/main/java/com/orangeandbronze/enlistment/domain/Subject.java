package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class Subject {
	private final String subjectCode;
	private Subject prerequisiteSubjectCode;
	
	private static final Subject NONE = new Subject("",null); //null pattern match
	
	public Subject(String subjectCode, Subject prerequisiteSubjectCode){
		notBlank(subjectCode);
		this.prerequisiteSubjectCode = (prerequisiteSubjectCode != null) ? prerequisiteSubjectCode : Subject.NONE; 
		this.subjectCode = subjectCode;
	}
	
	
}
