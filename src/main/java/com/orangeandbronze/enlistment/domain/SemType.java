package com.orangeandbronze.enlistment.domain;

public enum SemType {
	FIRST(1), SECOND(2), THIRD(3);
		
	private int semValue;
	
	SemType(int semValue){
		this.semValue = semValue;
	}
	
	public boolean isPreviousSem(SemType otherSemType){
		if(this.semValue < otherSemType.semValue){
			return true;
		}
		return false;
	}
}
