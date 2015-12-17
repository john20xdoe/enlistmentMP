package com.orangeandbronze.enlistment.domain;

public enum Subject {
	
	ENG101,ENG202(ENG101),
	SCI101, SCI202(SCI101), SCI203(SCI202),SCI303(SCI203),
	MATH101, MATH202(MATH101), MATH203(MATH202),MATH404(MATH203),
	FIL101, FIL102(FIL101),FIL103(FIL102), FIL201(FIL103);
	
	private Subject prerequisite;
	
	private Subject(){}
	
	private Subject(Subject subject){
		this.prerequisite = subject;
	}
	
	public Subject getPrerequisite(){
		return prerequisite;
	}
	
	public boolean hasPrerequisite(){
		if(prerequisite != null){
			return true;
		}
		return false;
	}
}
