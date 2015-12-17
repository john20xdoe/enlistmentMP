package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class SemesterEnlistment {
	private final Section section;
	private final Semester semester;
	
	public SemesterEnlistment(Section section, Semester semester) {
		this.section = section;
		this.semester=semester;
	}

	@Override
	public String toString() {
		return semester + " " + section ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		return true;
	}
	
	
	
	
	

}
