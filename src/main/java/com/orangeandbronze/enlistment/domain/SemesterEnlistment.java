package com.orangeandbronze.enlistment.domain;


import static org.apache.commons.lang3.Validate.*;
import java.util.*;

public class SemesterEnlistment {
	private final Semester semester;
	private  Collection<Section> sections = new HashSet<>();
		
	public SemesterEnlistment(Semester semester) {
		notNull(semester);
		this.semester=semester;
	}

	public void enlistSection(Section otherSection){
		
		for(Section currentSection : this.sections){
			if(currentSection.hasSameSubject((otherSection))){
				throw new DuplicateSectionException("Cannot enlist section "+otherSection+" because an existing section with the same subject already enlisted");
			}
		}
		
		
		boolean isValid = true;
		
		if(otherSection.getPrereqSubject() != null){
			isValid = prereqExists(otherSection);
		}
		
		if(isValid){
			this.sections.add(otherSection);
		}
	}
	
	private boolean prereqExists(Section otherSection){
		boolean prereqExists = false;
		for(Section currentSection : this.sections){
			if(currentSection.hasSameSubject(otherSection) ){
				prereqExists = true;
				break;
			}
		}
		return prereqExists;
	}
	
	@Override
	public String toString() {
		return semester + " " + sections ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sections == null) ? 0 : sections.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SemesterEnlistment other = (SemesterEnlistment) obj;
		if (sections == null) {
			if (other.sections != null)
				return false;
		} else if (!sections.equals(other.sections))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		return true;
	}
	
	
	
	
	

}
