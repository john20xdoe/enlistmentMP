package com.orangeandbronze.enlistment.domain;

public enum SemesterType {
	FIRST(1), 
	SECOND(2), 
	THIRD(3);
		
	private int semValue;
	
	SemesterType(int semValue){
		this.semValue = semValue;
	}
	
	public boolean isPreviousSem(SemesterType otherSemType){
		
		return this.semValue < otherSemType.semValue;
	}
}
