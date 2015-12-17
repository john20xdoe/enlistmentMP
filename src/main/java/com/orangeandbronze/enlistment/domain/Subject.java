package com.orangeandbronze.enlistment.domain;

public enum Subject {
	
	ENG101,
	ENG202(ENG101);
	
	private Subject prerequisite;
	
	private Subject(){}
	
	private Subject(Subject subject){
		this.prerequisite = subject;
	}
	
	public Subject getPrerequisite(){
		return prerequisite;
	}
}
